SC-Ledger-2
============

**ARCHIVED** - A tool for processing flat file based stock data. Unlike the previous SC-Ledger exercise this one was approached
as if the code were being written "in a day job" as opposed to "hacking a solution together".

Building The Application
-------------------------

You must have:
* Maven 2.2.0 or greater
* Java 6 or higher

Tne project can be built by executing mvn:install.

Running The Application
-----------------------

The application can be started by executing "mvn jetty:run" which starts a Jetty server on
http://localhost:8080

Notes
------------

* The application is non-functional, that is the UI does not have have any functionality, and the application does not work "end to end"
* Only 6 hours was spent developing this code
* The main aim was to follow good development practices to procude production quality code using TDD/BDD
* The project will current fail to compile due to a failing test which is part of the story to implement submission report file rows containing stock data

Next Steps
------------

* Complete the current TDD cycle and implement full submission report file parsing
* Complete persistence of Report and associated ReportLine objects
* Add UI feature to upload report files
* Add 4 reports specified in SC-Ledger challenge specification
