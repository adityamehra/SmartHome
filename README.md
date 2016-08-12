# Note: This project uses parse as BaaS, so it may no longer work correctly.

# SmartHome
This is the repo of my project  for CS6600.

In this project, I am mainly focusing on how to make a thermostat aware of the user. This can be achieved by providing the thermostat the location of the user via his phone. Also, the thermostat can know the schedule of the user in advance via the Google Calendar. Once we have all this data, system can also predict the curent energy usage by the user.The user can set the location of his home, which is stored on the Parse.com. Parse.com is being used as the BaaS(Backend as a Service).
Once the user sets the location of the house, a Geofence (https://en.wikipedia.org/wiki/Geo-fence) is created for this location. Whenever the user enters/exists this geofence, an event is trigerred which lets the thermostat know that user has left the location.

#What?
This project is mainly used for two things -

1. To provide users location to the system.

2. To provide users schedule to the System from the Google Calendar.

This can then be used to provide the user with current energy usage.

#Why?
Mobile phones are now inseperable part of ones life, thus can be used to get info about the user at all times.

By knowing the location and schedule of the user, the system can predict  better energy usage patterns by the user. Thus, helping the user in saving enrgy.

The thermostat can shut down the heating system when the user is not at home.

#How?

1. Location:-

  The location of the user can be accessed via the users phone. I have used Google Location API to do this.
  
2. Scheduel:-

  The schedule is taken from Google Calendar. To access Google Calendar, I have used Google Calendar API. The location and     time of the event can be extracted from there.

3. Weather:-

  I have used the API provided by forecast.io to provide the details like temperature, sky cover, precipitation.


# Resources

This project uses resources from:-

1. Google location API.

2. Google Calendar API.

3. Parse as BaaS.

4. http://www.androidhive.info/2015/02/android-location-api-using-google-play-services/

5. API from forecast.io. 



