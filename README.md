# Mobile App 2 : Personnal 
## Julie HEIM 26282

### Checklist

1) Display markers on the map
- [x] Load places and place types JSON data1
- [ ] Display marker for all places using GPS coordinates
- [ ] Use different colours, one for each place type
- [ ] When marker is tapped, place name should be displayed on a pop-up info window
2) Show extended information
- [ ] When the pop up info window is tapped, show in full screen all details of the place (id, name, Gaelic name, type, GPS coordinates)
- [ ] Show the image of the place loaded from the internet2
- [ ] [Bonus] Show relevant image using any free web service, or search engine
- [ ] Show a back button, when pressed, go back to map view
3) Allow filtering by Place Type
- [ ] Show dropdown for selecting Place Type, default value should be all
- [ ] When a specific Place Type is selected, show only the places with this Place Type on the map
4) Allow custom marker
- [ ] Long Press anywhere on map to show a draggable marker
- [ ] Show distance3 to the nearest place (from the downloaded data), and on drag marker, update this info
- [ ] Draw a semi-transparent blue circle around this marker with a radius of 10 km and show number of places within this radius
- [ ] [Bonus] Create a slider to control the above radius in km (1-1000, default 10) and on change, update the circle on the map and update number of places within the radius info shown accordingly

### Report 

This project and this course in general were very hard to follow. I started this course with zero knowledge on how to create a mobile app and I didn’t even know the existence of Android Studio. I tried my best to work on the group project with my colleague and it was easier to work with someone who had some knowledge and the subject. I thought it was a good thing to practice on the group project before starting my own. Maybe it was not because we spent a lot of time on this one. 
When I tried to begin the personal project and had some difficulties with my API key that was not available anymore on my Google Account. Then I tried to implement a get() to load the places and the places type from the URL given but it was very hard to be sure those ones were actually loaded as I don’t really know what object was created. I tried to figure out with the logcat, something that one more time, I don’t understand. Once I thought it was a success, I had to exploit the data. That’s were I gave up … I had no idea were to begin and the documentation about the JSON objects was so hard to understand. I tried many things that didn’t worked. My idea was to create a foreach() loop on an array to display each marker with his informations. But creating the array was a mess. Without this step it was impossible to continue. So here is my "project" if we can call it like that.
