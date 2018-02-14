# InventoryManagement

## Synopsis
This is an Inventory Management program where user can provide various commands like Create, UpdateBuy, UpdateSell, Delete to manage the inventory and also able to see the detailed information about the items and the profit using the command report


## Code Example

I have used apache-chain command pattern to solve this problem as there are various commands that user wants to execute and based on the command type correspnding Command class gets executed and performs its task.

## Tests

Download the code in your local environment and run the command mvn install - this command will run the jUnit test as well as build the jar under target folder. Go inside the target folder from your command prompt and the run the command 

``` Run Command
java -jar inventory-1.0-SNAPSHOT-jar-with-dependencies.jar
```
Sample Input
```Input
create Book01 10.50 13.79
create Food01 1.47 3.98
create Tab01 57.00 84.98
create Med01 30.63 34.29
updateBuy Tab01 100
updateSell Tab01 2
updateBuy Food01 500
updateBuy Book01 100
updateBuy Med01 100
updateSell Food01 1
updateSell Food01 1
updateSell Tab01 2
report
delete Book01
updateSell Tab01 5
create Mobile01 10.51 44.56
updateBy Mobile01 250
updateSell Mobile01 4
updateSell Food01 5
updateSell Med01 10
report
#
```
Sample Output
```Output
INVENTORY REPORT
Item Name		Bought At		Sold At		Available Qty		Value
---------		---------		-------		-------------		-----
Book01			10.50			13.79			100			1050.00
Food01			1.47			3.98			498			732.06
Med01			30.63			34.29			100			3063.00
Tab01			57.00			84.98			96			5472.00
Total Value : 10317.06
Profit since previous report : 116.94


INVENTORY REPORT
Item Name		Bought At		Sold At		Available Qty		Value
---------		---------		-------		-------------		-----
Food01			1.47			3.98			493			724.71
Med01			30.63			34.29			90			2756.70
Mobile01			10.51			44.56			246			2585.46
Tab01			57.00			84.98			91			5187.00
Total Value : 11253.87
Profit since previous report : -724.75
```
