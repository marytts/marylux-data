# MaryLux Data

Multilingual Luxembourgish/French/German speech database for the MaryLux TTS voices in [MaryTTS](http://mary.dfki.de/), recorded in 2014 at Saarland University by Judith Manzoni.

## Format

The audio data is provided in a single [FLAC](https://xiph.org/flac/) file, recorded at 48 kHz sampling frequency with 16 bit per sample.

The textual data is provided in a single [YAML](http://yaml.org/) file.
This file is a list of utterances, each of which contains
- a **prompt** code (file basename),
- the utterance **text**,
- utterance **start** and **end** times (in seconds) in the FLAC file,
- optionally, the phonetic **segments**, each of which has
    - a **lab**el (based on [SAMPA](http://www.phon.ucl.ac.uk/home/sampa/english.htm), `_` denotes silence), and
    - its **dur**ation (in seconds)

For example,
```yaml
- prompt: lb-northwind-0001
  text: Den Nordwand an d''Sonn
  start: 5.859
  end: 7.261
  segments:
  - {lab: _, dur: 0.095}
  - {lab: d, dur: 0.07}
  - {lab: '@', dur: 0.025}
  - {lab: n, dur: 0.015}
  - {lab: n, dur: 0.07}
  - {lab: o, dur: 0.055}
  - {lab: R, dur: 0.145}
  - {lab: d, dur: 0.03}
  - {lab: v, dur: 0.05}
  - {lab: A, dur: 0.075}
  - {lab: n, dur: 0.045}
  - {lab: t, dur: 0.02}
  - {lab: a~, dur: 0.14}
  - {lab: t, dur: 0.03}
  - {lab: z, dur: 0.11}
  - {lab: o, dur: 0.12}
  - {lab: n, dur: 0.105}
  - {lab: _, dur: 0.201}
```

## Downloading the data

Use the links on the [releases](../../releases) page, or run the `downloadAudio` task (see below).

## Converting the data

For convenience, the utterances for each subset can be be extracted from the YAML and FLAC files using simple commands to run [Gradle](https://gradle.org/) tasks.
After cloning or downloading and unpacking this repository, run `./gradlew tasks` (or `gradlew tasks` on Windows) for details.

### Prerequisites

You will need [Java](https://www.java.com/) to run the tasks. Extracting the utterances to WAV files also requires [`sox`](http://sox.sourceforge.net/) to be installed.

### Copyright and license

Copyright 2014 [DFKI GmbH](http://dfki.de/).

[![Creative Commons License](http://mirrors.creativecommons.org/presskit/buttons/88x31/svg/by-nc-sa.svg)](http://creativecommons.org/licenses/by-nc-sa/4.0/)

This work is licensed under a [Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License](http://creativecommons.org/licenses/by-nc-sa/4.0/).
