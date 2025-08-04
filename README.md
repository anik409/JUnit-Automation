# JUnit Automation Project

This repository contains two automated test scripts using Selenium WebDriver and JUnit:

1. **Task 1 – User Registration Automation** (`MyJUnit.java`)
2. **Task 2 – DSE Table Scraping** (`DseTableScraperTest.java`)

---

## Table of Contents

* [Prerequisites](#prerequisites)
* [Project Structure](#project-structure)
* [How to Run](#how-to-run)
* [Task 1 – Registration Automation](#task-1--registration-automation)

  * [Description](#description)
  * [Demo & Report](#demo--report)
* [Task 2 – DSE Table Scraping](#task-2--dse-table-scraping)

  * [Description](#description-1)
  * [Output File](#output-file)
  * [Demo & Report](#demo--report-1)

---

## Prerequisites

## Technologies

* Java 17+

* Selenium WebDriver 4.x

* JUnit 5 (JUnit Jupiter)

* Gradle

* Java 17+

* ChromeDriver available on PATH or configured via `webdriver.chrome.driver`

* Internet connection

* Maven or Gradle (this project uses Gradle)

## Project Structure

```
JUnit-Automation/
├── MyJUnit.java               # Task 1 test class
├── DseTableScraperTest.java   # Task 2 test class
├── dse_table_output.txt       # Sample output for Task 2
├── README.md                  # This file
└── .gitignore
```

## How to Run

1. Clone the repo:

   ```bash
   git clone https://github.com/anik409/JUnit-Automation.git
   cd JUnit-Automation
   ```
2. Execute tests via Gradle:

   ```bash
   ./gradlew test
   ```
3. After Task 2 runs, `dse_table_output.txt` is generated in the project root.

---

## Task 1 – Registration Automation

### Description

Automates filling and submitting the user-registration form at:
`https://demo.wpeverest.com/user-registration/guest-registration-form/`

**Steps Covered:**

1. Navigate to the registration page
2. Fill required fields: Firstname, Lastname, Email, Password, Gender, DOB, Nationality, Phone, Country, Terms & Conditions
3. Submit the form
4. Assert that the success message appears: *User successfully registered.*

### Demo & Report

**Video Demo:** [▶️ View Task 1 Demo](https://drive.google.com/file/d/13CUiTOurI7TGNX86GqSC-48iedzKzDL8/view?usp=drive_link)

**Test Report Screenshot:**

<img width="1271" height="639" alt="task1_report" src="https://github.com/user-attachments/assets/73a27704-7699-4ada-8cb4-2eba0f91a465" />


---

## Task 2 – DSE Table Scraping

### Description

Automates scraping of the latest share price table from DSE:
`https://dsebd.org/latest_share_price_scroll_by_value.php`

**Steps Covered:**

1. Navigate to the DSE page
2. Locate the share-price table
3. Iterate through all rows and cells
4. Print each cell’s text to the console
5. Save all values to `dse_table_output.txt`

### Output File

A sample output file is included:

```
$(head -n 3 dse_table_output.txt)...
```

*(First three rows of output)*

### Demo & Report

**Video Demo:** [▶️ View Task 2 Demo](https://drive.google.com/file/d/108E8msws9EUyPut2v0npN842qKgza4Ml/view?usp=sharing)

**Test Report Screenshot:**

<img width="1267" height="641" alt="task2_report" src="https://github.com/user-attachments/assets/d829310f-1acf-4162-8d7e-9f6a29990218" />


---

*All necessary IDE and build artifacts are excluded via `.gitignore`.*
