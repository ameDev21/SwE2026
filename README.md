# SwE2026

Lab exercises for the Software Engineering course, 
taught at Polimi, Fall 2026.

## Structure

Each lab lives in its own folder (tree generally not updated, take this just a general example of the code structure):

```
SwE2026/
    src
    ├── lab1
    │   ├── Fraction
    │   │   ├── Fraction.java
    │   │   └── Main.java
    │   ├── Poly
    │   │   ├── Main.java
    │   │   ├── Point.java
    │   │   └── Polygon.java
    │   └── specs
    │       └── SwE2026_Ex1.pdf
    └── lab2
        ├── README.md
        ├── School
        │   ├── Contents
        │   │   ├── Course.java
        │   │   ├── Exam.java
        │   │   ├── Grade.java
        │   │   ├── Semester.java
        │   │   └── SemesterType.java
        │   ├── Handlers
        │   │   └── InvalidPathException.java
        │   ├── Main.java
        │   └── Users
        │       ├── Data
        │       │   └── students.csv
        │       ├── Person.java
        │       ├── Professor.java
        │       ├── Student.java
        │       └── StudentsAdmin.java
        └── specs
            ├── SwE2025_Ex2.pdf
            └── SwE2026_Ex3.pdf
```
## Build and run

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
