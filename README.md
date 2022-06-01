# What does this application do?

A Java application which is designed to generate artificial logfiles in a CSV-format.

Generated logs are supposed to represent transactional data from an ERP-System.

I needed an application like this when I was working on a university project in which I was supposed to implement an analysis in a Process Mining Tool but
had no access to an ERP-System or Demo-Logfiles which met my requirements.

Templates for Activities and Variants are in the activities.json and variants.json files.

Activities are a ERP-transaction (i. e. send invoice), which can be repeated as often as you like. The Activity-Type indicates, whether additional transaction information should be generated (i. e. a payment ammount). 

Variants are an ordered list of Activities, which will be executed.

Each Activity in a Variant will be turned into an event, including timestamp an information about the transaction.

The User is able to choose how many instances of a Variant the program is supposed to generate. Each of those instances is called a case. 

Events are assigned to Cases by the CaseID.
