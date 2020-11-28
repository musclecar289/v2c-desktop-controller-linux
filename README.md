# V2C Desktop Controller for Linux

*Copyright (c) 2020 V2C Development Team. All rights reserved.*

## License

**This repository is subject to the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).**

---

## Build

You need Java 11. This project can be tested and compiled with the following command.
    
`chmod u+x ./gradlew`

`./gradlew clean shadowJar`

## Execution

To run it, just do `java -jar build\libs\v2c-desktop-controller-linux.jar`.

You can optionally specify some command-line arguments.

|Short Param|Long Param|Description        |Default   |Comment                                               |
|:----------|:---------|:------------------|:---------|:-----------------------------------------------------|
|-p         |--port    |The port number    |5698      |You do not have to provide a port by default.         |
|-u         |--u       |Enables UI         |Disabled  |Left for future reference, not currently implemented. |

---

## Command Mode

  > target desktop

To enter Command Mode
  > alteration command

---

## Typing Mode
  > target desktop (you only need to target once)

To enter Typing Mode
  > alteration typing

  - Features
    - alteration select - begin cursor selection at selected location
      - move- use to move in selected text.
        - SAMPLE DIRECTIVE "target desktop alteration select please move 5 right done alteration copy please type enter enter enter done alteration paste"
        - Behavior: the above sample should select 5 characters from your cursor location, copy them, enter three newlines and paste them at the newline
      - undo - directive to undo the previous token in typing or streaming mode
        - SAMPLE DIRECTIVE 2 (immediately following other sample): "please type undo undo undo done. type undo done"
        - behavior: jon is removed, one character at a time, as it was entered via keypress. "is " is removed on the last one, as it is a printed token.
    - alteration copy - copy currently selected text
        - SAMPLE DIRECTIVE "target desktop alteration select please move 5 right done alteration copy please type enter enter enter done alteration paste"
        - Behavior: the above sample should select 5 characters from your cursor location, copy them, enter three newlines and paste them at the newline
    - alteration paste - paste from clipboard
        - SAMPLE DIRECTIVE "target desktop alteration select please move 5 right done alteration copy please type enter enter enter done alteration paste"
        - Behavior: the above sample should select 5 characters from your cursor location, copy them, enter three newlines and paste them at the newline
    - Alteration alt - hold down, or release the alt button if it is held.
    - Alteration tab - hit the tab key.
    - USE ALT + TAB IN CONJUNCTION TO NAVIGATE WINDOWS
      - SAMPLE DIRECTIVE "target desktop alteration alt alteration tab alteration tab alteration alt.
      - Behavior: should switch windows
  - Some example commands would be as follows
     - "**type**"
       - “**please type** Juliet Oscar November **done**”
       - "**type** newline **done**"
       - "**type** alpha bravo Charlie **cancel type** Charlie bravo alpha **done**"
       - "**please type** the letters delta Oscar November echo **done**"
       - "**please type** shift one (to type an exclamation) shift J (to type a capital J) **done**"
         - If you say type shift too quickly it will send typeshift, and not recognize the token. You will still be in the initial state in the DFA, so all is good once you say it right.
     - **move** cursor
       - "**move** 3 up **done**"
         - Current build can only handle number literals, if you have “three” instead of “3”, it will not crash, but will return an error message in the desktop log.
       - "please **move** 2 right cancel move 1 right **done**"
       - "please **move** 4 spaces left"
     - backspace
       - "please backspace 3 spaces **done**//same issue in current build, must get number literals for recognizer. Plans to handle strings like “three” in works for Robot/hyperviser(ENUM)"
       - "backspace 3 cancel backspace 4 **done**"
       - "backspace 3 times **done**"
       - "backspace 2 spaces cancel backspace 1 **done**"

### Typing Mode Schema
![Typing Mode Schema](typingModeSchema.png)

---

## Streaming Mode
  > target desktop

To enter Streaming Mode
  > alteration streaming

  - same as typing mode, except if your word is not a keypress it will type that word
  - Features
    - alteration select - begin cursor selection at selected location
      - move- use to move in selected text.
        - SAMPLE DIRECTIVE "target desktop alteration select please move 5 right done alteration copy please type enter enter enter done alteration paste"
        - Behavior: the above sample should select 5 characters from your cursor location, copy them, enter three newlines and paste them at the newline
      - undo - directive to undo the previous token in typing or streaming mode
        - SAMPLE DIRECTIVE "target desktop alteration streaming please type my name is john undo juliet oscar november done"
        - Behaviour: my name is John is typed, John is removed, jon is typed.
        - SAMPLE DIRECTIVE 2 (immediately following other sample): "please type undo undo undo done. type undo done"
        - behavior: jon is removed, one character at a time, as it was entered via keypress. "is " is removed on the last one, as it is a printed token.
      - MODE NOTE: streaming mode, it will remove a character or token(printed word). typing mode only types characters, so it works like a single backspace essentially.
    - alteration copy - copy currently selected text
        - SAMPLE DIRECTIVE "target desktop alteration select please move 5 right done alteration copy please type enter enter enter done alteration paste"
        - Behavior: the above sample should select 5 characters from your cursor location, copy them, enter three newlines and paste them at the newline
    - alteration paste - paste from clipboard
        - SAMPLE DIRECTIVE "target desktop alteration select please move 5 right done alteration copy please type enter enter enter done alteration paste"
        - Behavior: the above sample should select 5 characters from your cursor location, copy them, enter three newlines and paste them at the newline
    - Alteration alt - hold down, or release the alt button if it is held.
    - Alteration tab - hit the tab key.
    - USE ALT + TAB IN CONJUNCTION TO NAVIGATE WINDOWS
      - SAMPLE DIRECTIVE "target desktop alteration alt alteration tab alteration tab alteration alt.
      - Behavior: should switch windows
  - Some example commands would be as follows
     - "**type**"
       - “**please type** Juliet Oscar November **done**”
       - "**type** newline **done**"
       - "**type** alpha bravo Charlie **cancel type** Charlie bravo alpha **done**"
       - "**please type** the letters delta Oscar November echo **done**"
       - "**please type** shift one (to type an exclamation) shift J (to type a capital J) **done**"
         - If you say type shift too quickly it will send typeshift, and not recognize the token. You will still be in the initial state in the DFA, so all is good once you say it right.
     - **move** cursor
       - "**move** 3 up **done**"
         - Current build can only handle number literals, if you have “three” instead of “3”, it will not crash, but will return an error message in the desktop log.
       - "please **move** 2 right cancel move 1 right **done**"
       - "please **move** 4 spaces left"
     - backspace
       - "please backspace 3 spaces **done**//same issue in current build, must get number literals for recognizer. Plans to handle strings like “three” in works for Robot/hyperviser(ENUM)"
       - "backspace 3 cancel backspace 4 **done**"
       - "backspace 3 times **done**"
       - "backspace 2 spaces cancel backspace 1 **done**"
---
