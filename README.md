# urlshorten
URL Shorterner API built with Java + Spring

## Where's all the code ?
Everything is under `com.philjauvin.urlshorten`

## How do I set it up ?

Download/clone the repo and import the project into Intellij - the gradle build file should install any dependencies.  
Once this is done, executing the `main` method in the `UrlshortenApplication` class will start a server you can access at `localhost:8080`

## Visiting a shortened URL  
Once URLs have been created in the system (see _API Routes_ below), you can visit them by going to `/goto/{id}` in your browser.  
For example, suppose I've created a new shortened URL for `http://google.ca` that has an ID of `a4b5`, visiting `localhost:8080/goto/a4b5` will redirect me to `http://google.ca`

## API Routes  

With the exception of `DELETE` requests, the API will always a JSON object in the following format - This is also the format you should use when sending PUT requests

```javascript
{
  "id" : "XXXX",
  "destination" : "http://yourfavouritesite.co.uk"
}
```  

### Fetching a URL by its ID
`GET /api/fetch/{id}`  

### Inserting a new URL  
`GET /api/makenew?destination={destination}`  

### Updating an existing URL  
`PUT /api`  
The request body should contain a URL object in JSON format  
Note that the ID field should match an existing URL's otherwise the update will fail  

### Deleting a URL  
`DELETE /api/{id}`  
