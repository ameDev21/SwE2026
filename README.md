# SwE2026

Lab exercises for the Software Engineering course, 
taught at Polimi, Fall 2026.

## Structure

Each lab lives in its own folder:

```
SwE2026/
├── lab1/
├── lab2/
│   ├── src/lab2/School/...   # Java sources / csv files for data storing
│   ├── bin/                  # compiled classes (not tracked)
│   └──
└── ...
```

## Build and run

Requires a JDK (17 or newer). From inside a lab folder, e.g. `lab2/`:

```bash
javac -g -d bin src/lab2/School/*.java
java -cp bin School.Main
```

Run from the lab folder so relative paths like `./input.csv` resolve correctly.

## Debug

```bash
jdb -classpath bin -sourcepath src/lab# package.Main
```

## Author

[AmeDev21](https://github.com/AmeDev21)
