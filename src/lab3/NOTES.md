# Lab 3 — ConcurrentBank: Notes

> Author: _your name_
> Last update: _date_

## Environment

Concurrency results depend on the machine, so record it once here.

| | |
|---|---|
| OS | Arch Linux |
| Java version (`java -version`) | |
| CPU cores (`nproc`) | |

---

## How to read these notes

Each step uses the same structure:

1. **Expected** — what I *thought* would happen, written **before** running the code
2. **Observed** — what actually happened (output, numbers, screenshots)
3. **Why** — the explanation, using the terms from the notes (monitor, data race, happens-before, …)
4. **Fix** — what I changed and why it works (if there was a bug)
5. **Questions** — answers to the questions in the README

---

## Step 0 — The single-threaded bank

### Design decisions
- Money as `long` cents instead of `double` because: for exact decimal precision for binary rappresentation of decimal numbers like 0.10. 
- `InsufficientFundsException` is **checked / unchecked** because: unchecked, we think the 
caller made a wrong call since it could check if the amount in the account is not enough.
- Composition vs aggregation between `Bank` and `Account`: …

### Questions
**Q1. Would aggregation make sense instead of composition?**
Not really, does not have much sense to have the 
possiblity of creating an account without it being associated with 
a (or THE) bank.
…

---
TODO: FROM HERE!!
## Step 1 — First threads

### Expected
…

### Observed
Output with `start()`:
```
paste a short sample here
```

Output with `run()`:
```
paste a short sample here
```

| Version | Total time (ms) | Executing thread(s) |
|---------|-----------------|---------------------|
| `start()` | | |
| `run()` | | |

### Why
…

### Questions
**Q1. Why prefer `Runnable` over extending `Thread`?**
…

**Q2. Is the order of the lines always the same over 5 runs? Why?**
…

---

## Step 2 — `join()`

### Expected
…

### Observed
| Run | Total WITHOUT `join()` | Total WITH `join()` |
|-----|------------------------|---------------------|
| 1 | | |
| 2 | | |
| 3 | | |

States seen with `getState()`:

| Moment | State |
|--------|-------|
| before `start()` | |
| while sleeping | |
| after `join()` | |

### Why
…

### Questions
**Q1. Why is the total wrong without `join()`?**
…

**Q2. How does "all actions of a thread happen-before the return of `join()`" guarantee visibility?**
…

---

## Step 3 — Race condition 💥

### Expected
…

### Observed
Expected final balance: `…`

| Run | Actual balance | Lost updates |
|-----|----------------|--------------|
| 1 | | |
| 2 | | |
| … | | |
| 10 | | |

Mixed deposits and withdrawals, anything "impossible"?
…

### Why
…

### Questions
**Q1. Which separate actions make up `balance += amount`?**
…

**Q2. An interleaving that loses a deposit** (fill in the table):

| Time | Thread A | Thread B | balance in memory |
|------|----------|----------|-------------------|
| t1 | | | |
| t2 | | | |
| t3 | | | |
| t4 | | | |

**Q3. Which two accesses form a data race (§3.4.3)?**
…

---

## Step 4 — `synchronized`

### Fix
- Version 1 (synchronized methods): …
- Version 2 (synchronized block on a private lock): …

### Observed
| Version | Correct? | Time (ms) |
|---------|----------|-----------|
| Unsafe | | |
| synchronized methods | | |
| synchronized block | | |

Does `getBalance()` need `synchronized`? What I tried and concluded: …

### Questions
**Q1. Which monitor does a `synchronized` method lock? And a `static synchronized` method?**
…

**Q2. Why lock a private object instead of `this`?**
…

**Q3. Explain the fix with "unlock happens-before subsequent lock".**
…

---

## Step 5 — Deadlock 🔒🔒

### Expected
…

### Observed
After how long did it freeze? …

`jstack` output (relevant part only):
```
Found one Java-level deadlock:
...
```

### Why
Draw the cycle: who holds what, who waits for what.
```
thread-X  holds A, waits for B
thread-Y  holds B, waits for A
```

### Fix
…

### Auditor results
| Version | Transfers | Invariant ever broken? | Unsafe-total mismatches |
|---------|-----------|------------------------|-------------------------|
| lock ordering + locked audit | | | |
| lock ordering + unlocked audit | | | |

### Questions
**Q1. The 4 conditions for deadlock, and which one lock ordering breaks:**
1. …
2. …
3. …
4. …

**Q2. Why does an unlocked audit see a wrong total even though no money is lost?**
…

**Q3. How can the auditor lock all accounts without causing a deadlock?**
…

---

## Step 6 — `wait()` / `notifyAll()`

### Expected
…

### Observed
Short sample of the log (who waits, who is woken up):
```
...
```

### Experiments
| Change | What happened | Why |
|--------|---------------|-----|
| `while` → `if` | | |
| `notifyAll()` → `notify()` | | |

### Questions
**Q1. Why must `wait()` be called while holding the monitor? What happens if not?**
…

**Q2. What happens to the monitor while a thread is waiting?**
…

**Q3. What is a spurious wake-up, and how does `while` protect against it?**
…

---

## Step 7 — Closing the bank

### Expected
…

### Observed
| Version | Did every customer stop? | Notes |
|---------|--------------------------|-------|
| unsynchronized flag | | |
| synchronized `isOpen()` / `close()` | | |
| + `interrupt()` for blocked customers | | |

### Why
…

### Questions
**Q1. Why can a thread read a stale value when nobody writes concurrently?**
…

**Q2. Why is catching `InterruptedException` and doing nothing a bad idea?**
…

---

## Summary

### What I learned
- …
- …

### Bugs I met and how I recognised them
| Bug | Symptom | How I diagnosed it | Fix |
|-----|---------|--------------------|-----|
| Race condition | | | |
| Deadlock | | | |
| Visibility | | | |
| Lost wake-up | | | |

### Open doubts / questions for the professor
- …

---

## Extensions (Part 2)

Copy this block for each extension you do.

### Extension: _name_ (e.g. A. Singleton)
- **Goal:** …
- **Design / UML:** …
- **Thread-safety issues found:** …
- **Results:** …
- **What I would improve:** …

---

## Glossary

Write each definition in your own words; it's good exam practice.

| Term | My definition |
|------|---------------|
| Monitor | |
| Race condition / data race | |
| Happens-before | |
| Synchronization edge | |
| Sequential consistency | |
| Deadlock | |
| Lost wake-up | |
| Spurious wake-up | |
