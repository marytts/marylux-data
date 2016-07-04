filedelete marylux-data.yaml
Read from file... marylux-data.TextGrid
ni = Get number of intervals... 1
for i to ni
  yaml$ = ""
  label$ = Get label of interval... 1 i
  re$ = "^(.+?): ?(.*?)$"
  if index_regex(label$, re$)
    prompt$ = replace_regex$(label$, re$, "\1", 1)
    start = Get start point... 1 i
    start$ = fixed$(start, 3) - "0" - "0" - "0" - "."
    end = Get end point... 1 i
    end$ = fixed$(end, 3) - "0" - "0" - "0" - "."
    text$ = replace$(replace_regex$(label$, re$, "\2", 1), """", "'", 0)
    text$ = replace$(text$, "'", "''", 0)
    text$ = if index(text$, ":") then "'" + text$ + "'" else text$ fi
    yaml$ = "'yaml$'- prompt: 'prompt$''newline$'  text: 'text$''newline$'"
    yaml$ = "'yaml$'  start: 'start$''newline$'  end: 'end$''newline$'"
    seg1 = Get interval at time... 2 start
    segn = Get interval at time... 2 end
    if seg1 != segn
      for s from seg1 to segn - 1
        lab$ = Get label of interval... 2 s
        if length(lab$)
          if s == seg1
            yaml$ = "'yaml$'  segments:'newline$'"
          endif
          lab$ = if index_regex(lab$, "[@?:0-9{}]") then "'" + lab$ + "'" else lab$ fi
          xmin = Get start point... 2 s
          xmax = Get end point... 2 s
          dur$ = fixed$(xmax - xmin, 3) - "0" - "0" - "0" - "."
          yaml$ = "'yaml$'  - {lab: 'lab$', dur: 'dur$'}'newline$'"
        endif
      endfor
    endif
  endif
  yaml$ >> marylux-data.yaml
endfor
