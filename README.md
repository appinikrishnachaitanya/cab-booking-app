# cab-booking-app
this is cab booking app

Tech Stack : Spring Boot , java

Driver Class is available in the com.cabbookingapp.api.driver, please see below image for reference

![image](https://github.com/appinikrishnachaitanya/cab-booking-app/assets/31736263/54d41935-fedf-4c5c-af7f-2b2c2108ee4c)

Test Cases:

Case -1 : Adding the users 

Description : 

We created UserDataStore to store the all users ,please refer the UserRepository 

![image](https://github.com/appinikrishnachaitanya/cab-booking-app/assets/31736263/33312585-b23c-4b44-9c7e-c3558c3753b5)

Output:

![image](https://github.com/appinikrishnachaitanya/cab-booking-app/assets/31736263/3330ffca-e99b-4616-b58d-f112fbd782cf)

Case -2 : Adding the Drivers

Description :

We created  DriversDataStore to store all drivers, please refer the DriverRepository

Input:

![image](https://github.com/appinikrishnachaitanya/cab-booking-app/assets/31736263/a112fca0-120c-4476-9b0e-0b3e41429a73)

Output:

![image](https://github.com/appinikrishnachaitanya/cab-booking-app/assets/31736263/4e7d5f1b-4178-44e3-8dce-e579e0471339)

Case -3 : Finding the nearest Drivers:

Description:

We will find the drivers who are less than 5 units from user place, updated the available drivers to users

Input:

![image](https://github.com/appinikrishnachaitanya/cab-booking-app/assets/31736263/376c9b99-c98b-421c-a6b8-1fc133349792)

Output:

![image](https://github.com/appinikrishnachaitanya/cab-booking-app/assets/31736263/3a41f0d9-05f3-4d55-ba6a-0955ba2ad8cd)


Case-4: Multithreading case

Description:

Here we are trying to book the same driver 

From, above the above figure it is clear that rahul has driver 1 as available

Input:

Here we can see that Rahul and Abishek has Driver 1 as availableDriver but only one can book

![image](https://github.com/appinikrishnachaitanya/cab-booking-app/assets/31736263/4d5724a0-aa89-48a5-a941-c65c7e8cb59d)

Output:

![image](https://github.com/appinikrishnachaitanya/cab-booking-app/assets/31736263/624ed190-3573-40e2-ae19-86bc2bf3a0b3)

