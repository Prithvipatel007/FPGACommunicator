# FPGACommunicator

FPGACommunicator is a tool that basically communicates with thr FPGA using UART-COM port. This tool is built in JAVA and can be used to read and write the Hexadecimal values from/to the FPGA.

In order to work with it:

1. Install java runtime environment
2. Install Eclipse IDE
3. Open the project in Eclipse IDE and run the project.

Considerations:

1. FPGA needs to be connected via COM port otherwise it will not work.
2. Jserialconnector library is used, so make sure you read the documentation of it beforehanded.
3. MVC pattern is used for the development.
4. Only Hexadecimal data can be sent or retrieve from the FPGA.

Hope it works for you. 

Any questions, contact me at:

[linkedin-url]: https://linkedin.com/in/prithvi-patel-38665410a
