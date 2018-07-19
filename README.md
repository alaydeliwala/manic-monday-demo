# lynx-db RESTful API Documentation
The intial path of this web api is `http://lynx-database-lynx-database.ocp-ctc-core-nonprod.optum.com'
## Path `/test`
* This path checks to see if the connection between the server and the UI is up and returning.
If connection is established you should expect `Connection Established`

## Path `/import`
* This path will populate your database for local testing.
If import is succesful you should expect `Import Complete`

## Path `/patient`
* This path is for queries related to pateints as an object.
Output for Patient JSON Objects will be like below:
``` json
{
    "id": 101,
    "username": "lynx-patient",
    "password": "password",
    "name": "Lynx",
    "email": "lynx@gmail.com",
    "phone": "7046269313",
    "insuranceNumber": 1,
    "provider": {
        "id": 1,
        "name": "Dr. Parekh",
        "email": "doctor@gmail.com",
        "phone": "2252008512"
    }
}
```

### `/add`
* Adds a new user into the database
#### Parameters
* **username** the username of the user
* **password** the password of the user
* **name** the name of the user
* **email** the email of the user
* **phone** the phone number of the user
* **insuranceNumber** the insuranceNumber of the user
#### Responses
* If succesful expect `New Patient has been added`
* If unsuccesful expect ``

### `/addWithProvider`
* Adds a new user with a provider into the database
#### Parameters
* **username** the username of the user
* **password** the password of the user
* **name** the name of the user
* **email** the email of the user
* **phone** the phone number of the user
* **id** the id of the provider
* **insuranceNumber** the insuranceNumber of the user
#### Responses
* If succesful expect `New Patient has been added`
* If unsuccesful expect `User was not able to be added`

### `/find`
* Find a specific user in the database
#### Parameters
* **name** the name of the user
#### Responses
* If succesful expect JSON object of a patient
* If unsuccesful expect `[]`

### `/all`
Gets all the users that are in the database
#### Responses
* If succesful expect JSON object of a patient
* If unsuccesful or empty expect `[]`

### `/getSymptomsList`
* Return list of symptoms associated with specific patient
#### Parameters
* **name** the name of the user
#### Responses
* If succesful expect a list of JSON symptom objects
* If unsuccesful expect `[]`

### `/addSymptom`
* Add a symptom to a specific patient
#### Parameters
* **name** the name of the user
#### Responses
* If succesful expect `Symptom Added`
* If unsuccesful or empty expect `Invalid Symptom`

### `/user/login`
* Logs a user into the system and makes them the current user
#### Parameters
* **username** the username of the user
* **password** the password of the user
#### Responses
* If succesful expect `Login Successful`
* If incorrect credentials expect `Invalid Credentials`
* If user is already logged in `User already logged in`

### `/user/logout`
* Logs out the current user
#### Responses
* If succesful expect `Logout Successful`
* If a user is already logged in expect `No user logged in`

### `/user/data`
* Get information about current logged in user
#### Responses
* If succesful expect JSON object of a current user
* If a user is already logged in expect `null` sdfasdfasdfadfasdfasdfasdfsadfsadf

### `/user/updateProvider`
* Updates the current Provider for the user
#### Parameters
* **id** the id of the new provider
#### Responses
* If succesful expect `Update Succesful`
* If id not found expect `Update Unsuccesful`
* If no user is logged in expect `No user logged in`

### `/user/addMember`
* Adds a new member to the current pateint list
#### Parameters
* **name** the name of the member
* **email** the email of the member
* **phone** the phone number of the member
* **type** the type of the member to add
#### Responses
* If succesful expect `New member added`
* If no user is logged in expect `No user logged in`

### `/user/distanceFromHospital`
* Finds the distance from a specified hospital
#### Parameters
* **name** the name of the hospital
#### Responses
* If succesful expect a distance
* If hospital not found expect `-1`

### `/user/inNetwork`
* Checks to see if the user has insurance covered by given hospital
#### Parameters
* **name** the name of the hospital
#### Responses
* If in network expect `true`
* If not in network expect `false`

### `/user/getSymptomsList`
* Gets the symptoms list for the specific patient
#### Responses
* If succesful expect a list of JSON symptom objects
* If unsuccesful expect `[]`

### `/user/addSymptom`
* Adds a symptom to the current list of symptoms
#### Parameters
* **name** the name of the symptom
#### Responses
* If succesful expect `Symptom Added`
* If unsuccesful or empty expect `Invalid Symptom`

## Path `/provider`
* This path is for queries related to providers as an object
Output for Provider JSON Objects will be like below
``` json
{
    "id": 201,
    "name": "Dr. Parekh",
    "email": "doctor@gmail.com",
    "phone": "2252008512"
}
```

### `/add`
* Adds a new provider into the database
#### Parameters
* **name** the name of the provider
* **email** the email of the provider
* **phone** the phone number of the provider
#### Responses
* If succesful expect `New Provider has been added`
* If unsuccesful expect ``

### `/find`
* Find a specific provider in the database
#### Parameters
* **name** the name of the provider
#### Responses
* If succesful expect JSON object of a provider
* If unsuccesful expect `[]`

### `/getPatients`
* Gets all the patients for a specific provider
#### Parameters
* **name** the name of the provider
#### Responses
* If succesful expect JSON list of Patients
* If unsuccesful expect `[]`

### `/all`
Gets all the providers that are in the database
#### Responses
* If succesful expect JSON list of patient objects
* If unsuccesful or empty expect `[]`

## Path `/member`
* This path is for queries related to members as an object
Output for Member JSON Objects will be like below
``` json
{
    "id": 301,
    "name": "Mom",
    "email": "mom@lynx.com",
    "phone": "7046269312",
    "type": "Family"
 }
```

### `/find`
* Find a specific member in the database
#### Parameters
* **name** the name of the member
#### Responses
* If succesful expect JSON object of a member
* If unsuccesful expect `[]`

### `/all`
Gets all the members that are in the database
#### Responses
* If succesful expect JSON list of member objects
* If unsuccesful or empty expect `[]`

## Path `/hospital`
* This path is for queries related to hospitals as an object
Output for Hospital JSON Objects will be like below
``` json
{
    "name": "Hospital",
    "latitude": 666.666,
    "longitude": 777.777,
    "type": "HOSPITAL",
    "insuranceNumber": 0
}
```

### `/find`
* Find a specific hospital in the database
#### Parameters
* **name** the name of the hosptial
#### Responses
* If succesful expect JSON object of a hospital
* If unsuccesful expect `[]`

### `/all`
Gets all the hospitals that are in the database
#### Responses
* If succesful expect JSON list of hospital objects
* If unsuccesful or empty expect `[]`

## Path `/symptom'
* This path is for queries related to Symptom as an object
Output for Symptom JSON Objects will be like below
``` json
{
    "name": "Swelling"
}
```

### `/find`
* Find a specific symptom in the database
#### Parameters
* **name** the name of the symptom
#### Responses
* If succesful expect JSON symptom of a hospital
* If unsuccesful expect `[]`

### `/all`
Gets all the symptoms that are in the database
#### Responses
* If succesful expect JSON list of symptom objects
* If unsuccesful or empty expect `[]`

### `/add`
Adds a symptom to the database
#### Parameters
* **name** the name of the symptom
#### Responses
* If succesful expect `Symptom has been added`
* If unsuccesful or empty expect `Invalid Symptom`


_Written by Alay Deliwala_
