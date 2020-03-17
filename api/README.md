# OKBoomer API
## Overview
Jank API built by Nathan Nesbitt.

This is an API that will serve up the information for the
OKBoomer phone application. It serves up the information in
JSON format.

## API Endpoints

### `/`

Generic information about the API (Will produce this page).

```
GET [domain]/

# Example

GET
    okboomer.nesbitt.ca/
    
    returns:
        <API Markdown Document>
```

### `/CreateAccount`

Creates an account for a specific user.

```
POST [domain]/CreateAccount

# Example with username and password
POST 
    okboomer.nesbitt.ca/CreateAccount
    
    contents: 
        name="Nathan"
        password="Password"
        email="example@email.ca"
        about="I am an old person looking for love."

    returns: 
        loggedIn=<key>
```

### `/Login`

Creates a session cookie for the current user.

```
POST [domain]/Login

# Example with username and password
POST 
    okboomer.nesbitt.ca/Login
    
    contents:
        email="example@email.ca"
        password="Password"
    
    returns: 
        loggedIn=<key>
```

### `/DeleteAccount`

Deletes an account for the current user.

```
POST [domain]/DeleteAccount

# Example with username and password
POST 
    okboomer.nesbitt.ca/DeleteAccount
    
    contents: 
        loggedIn=<key>
```

### `/AddPhoto`

Adds a photo for the current user.

```
POST [domain]/AddPhoto

# Example with Photo
POST 
    okboomer.nesbitt.ca/AddPhoto
    
    contents:
        photo=<Bitmap Array of Image>
    
```

### `/Photos/<UserID>`

Gets photos for the specified user.

```
GET [domain]/Photos/<UserID>

# Example with User
GET 
    okboomer.nesbitt.ca/Photos/1
    
    contents:
        loggedIn=<key>
    
```

### `/Photo/<PhotoID>`

Gets or Removes a photo for the current user. Delete Only works
if you are logged in and are the owner of that photo.

```
GET [domain]/Photo/<PhotoID>

# Example with Photo
GET 
    okboomer.nesbitt.ca/Photo/1
    
    contents:
        loggedIn=<key>

    returns:
        photo=<Bitmap Array Of Image>  
```

```
DELETE [domain]/Photo/<PhotoID>

# Example with Photo
DELETE 
    okboomer.nesbitt.ca/Photo/1
    
    contents:
        loggedIn=<key>  
```

### `/Users/Info/<ID>`

Gets the information about a user if logged in. Produces the 
personal information if the current user's ID is the same as
the requested user, else it requests the public information.

```
GET [domain]/Users/Info/<ID>

# Example with ID
POST 
    okboomer.nesbitt.ca/Users/Info/1
    
    contents: 
        loggedIn=<key>
    
    returns:
        name="Nathan"
```

### `/Users/Info/Location/<ID>`

Gets the location of a user based on their ID. This location 
should **not** be exact when returned, and should rather be
a delta distance calculated from the current logged in user
and the requested user. This is to provide security to the
requested user.

#### GET
```
GET [domain]/Users/Info/Location/<ID>

# Example with ID
POST 
    okboomer.nesbitt.ca/Users/Info/1
    
    contents: 
        loggedIn=<key>
    
    returns:
        distance=50
```

### `/PopCulture`

Gets the PopCulture Preferences that Exist. This will require that
you are logged in.

```
GET [domain]/PopCulture

# Example with ID
GET 
    okboomer.nesbitt.ca/PopCulture
    
    contents: 
        loggedIn=<key>
    
    returns:
        popCulture=List
```

### `/Users/Info/PopCulture/<UserID>`

Gets the PopCulture Preferences for a user. This will require that
you are logged in, and if you are POSTING (creating) you must be 
the user.

#### GET
```
GET [domain]/Users/Info/PopCulture/<UserID>

# Example with ID
GET 
    okboomer.nesbitt.ca/Users/Info/PopCulture/1
    
    contents: 
        loggedIn=<key>
```

#### POST
```
POST [domain]/Users/Info/PopCulture/<UserID>

# Example with ID
POST
    okboomer.nesbitt.ca/Users/Info/PopCulture/1
    
    contents: 
        loggedIn=<key>
        popCulture="PopCultureName"

```

### `/Users/Info/PopCulture/<UserID>/<PopCultureID>`

Updates or Deletes the PopCulture Preferences for a user. This
will require that you are logged in, and you must be the user.

#### POST

```
POST [domain]/Users/Info/PopCulture/<UserID>/<PopCultureID>

# Example with ID
POST 
    okboomer.nesbitt.ca/Users/Info/PopCulture/1/1
    
    contents: 
        loggedIn=<key>
        popCulture="PopCultureName"

```

#### DELETE

```
DELETE [domain]/Users/Info/PopCulture/<UserID>/<PopCultureID>

# Example with ID
DELETE 
    okboomer.nesbitt.ca/Users/Info/PopCulture/1/1
    
    contents: 
        loggedIn=<key>

```

### `/PreferedDates`
Gets a list of the preferred dates avalible.

#### GET
```
GET [domain]/PreferedDates

# Example
GET 
    okboomer.nesbitt.ca/PreferedDates
    
    contents: 
        loggedIn=<key>
```

### `/Users/Info/PreferedDates/<UserID>`
Gets the perfered dates for a user. This will require that
you are logged in, and if you are POSTING (creating) you must be 
the user.

#### GET
```
GET [domain]/Users/Info/PreferedDates/<UserID>

# Example with ID
GET 
    okboomer.nesbitt.ca/Users/Info/PreferedDates/1
    
    contents: 
        loggedIn=<key>
```

#### POST
```
POST [domain]/Users/Info/PreferedDates/<UserID>

# Example with ID
POST
    okboomer.nesbitt.ca/Users/Info/PreferedDates/1
    
    contents: 
        loggedIn=<key>
        preferedDate="PreferedDateName"
```


### `/Users/Info/PreferedDates/<UserID>/<PreferedDateID>`

Updates or Deletes the prefered date for a user. This
will require that you are logged in, and you must be the user.

#### POST

```
POST [domain]/Users/Info/PreferedDates/<UserID>/<PreferedDateID>

# Example with ID
POST 
    okboomer.nesbitt.ca/Users/Info/PreferedDates/1/1
    
    contents: 
        loggedIn=<key>
        preferedDate="PreferedDateName"

```

#### DELETE

```
DELETE [domain]/Users/Info/PreferedDates/<UserID>/<PreferedDateID>

# Example with ID
DELETE 
    okboomer.nesbitt.ca/Users/Info/PreferedDates/1/1
    
    contents: 
        loggedIn=<key>

```

### `/Users/Feed`
This gets the feed of possible users to consider.

#### GET
```
GET [domain]/Users/Feed

# Example with ID
GET 
    okboomer.nesbitt.ca/Users/Feed
    
    contents: 
        loggedIn=<key>
```

### `/Users/Likes/<UserID>`
Allows for the creation of a like of a user.

#### POST
```
POST [domain]/Users/Likes/<UserID>

# Example with ID of the user we are liking
POST 
    okboomer.nesbitt.ca/Users/Likes/1
    
    contents: 
        loggedIn=<key>
```

### `/Users/Matches/<UserID>`
Gets the matches for a user.

#### GET
```
GET [domain]/Users/Matches/<UserID>

# Example with ID
GET 
    okboomer.nesbitt.ca/Users/Matches/1
    
    contents: 
        loggedIn=<key>
```


### `/Users/Matches/<UserID>/<MatchID>`

Allows for the deletion of a match.

#### DELETE
```
DELETE [domain]/Users/Feed/<UserID>

# Example with ID
DELETE
    okboomer.nesbitt.ca/Users/Matches/1/1
    
    contents: 
        loggedIn=<key>
```
