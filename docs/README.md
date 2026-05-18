# Multi-Threaded Log Reader
A simple log file reader which utilises multiple [Java techniques](#java-techniques-used). Whilst this may be developed into a more fully fledged project in the future, initially this project was created to improve my skills in the Java programming language. I also used this project to further my understanding of git and different ways to merge branches into repositories.

## 📲 Installation & Usage
1) Clone the repo.
2) Compile and run Main.java.
3) Watch all the logs from logs.txt be printed in a much nicer way.

## 🧰 Design
### ☕ Java Techniques Used
- Inheritence
- Custom Exceptions & Handling
- File Data Input and Output
- Generics
- Threading

### 🏗 Repository Structure
```
MTLR
├── docs/
│   └── README.md
├── src/
│   └── main/
│       ├── java/com/logreader/
│       │   ├── buffer/
│       │   │   └── LogBuffer.java
│       │   ├── exception/
│       │   │   ├── LogAnalysisException.java
│       │   │   └── UnrecognizedLogTypeEx...
│       │   ├── model/
│       │   │   ├── ApplicationLogEntry.java
│       │   │   ├── AuthenticationLogEntry.j...
│       │   │   ├── DatabaseLogEntry.java
│       │   │   ├── EndOfStreamLog.java
│       │   │   ├── IdentifiableLog.java
│       │   │   ├── LogEntry.java
│       │   │   ├── LogLevel.java
│       │   │   ├── NetworkLogEntry.java
│       │   │   ├── SecurityLogEntry.java
│       │   │   └── SystemLogEntry.java
│       │   ├── processor/
│       │   │   └── LogProcessor.java
│       │   ├── util/
│       │   │   └── LogFileReader.java
│       │   └── Main.java
│       └── resources/
│           └── log.txt
├── tests/
├── .gitignore
└── LICENSE
```

### ‼️ Limitations
This is a very simple log file reader and thus the log files must use the following structure for logs: `{log type},{log id},{date and time},{log level},{log message},{log specific data}`

### 📝 Design Choices
#### 📖 Git Merge Commits
When merging branches with the main branch, I used the `--no-ff` flag to maintain branch topology and prevent the typical fast forward. When viewing in some IDEs, the use of the no fast forward flag make the graphical git history easier to follow and understand where each commit comes from.