![gws_logo](https://github.com/shareme/GWSDroidUuid/raw/master/readme_images/grottworkshop_logo.png)

GWSDroidUuid
---

Simple security-wise fool-proof method to determine a universal user ID to use in tracking of
application bugs per user, analytics, etc. Provided in Android Project Library format.

# Code Best Practices User ID Basics

The general idea is that we use a limited set of permissions in the AndroidManifest to allow us ot get
enough information to use better user ID. Sounds simple, yet even Groupon has goofed this up.

Okay some basics, every computer machine generates a machine ID no matter what OS operates that
devices. In the non phone device the mahcine ID is actually enough bits that you will not get any ID clashes per
the largets amount of users per application. In phones we can can use the SIM ID as long as we take some
hashing of the ID as a precaution and it to the machine ID.

There are three other edge cases. One, the emulator which will show a certain andriodID of 9774d56d682e549c
which is handled in the if case to set a random machineID,obviously what else would you set it too?  Some OEMs
had android 2.2 devices with the same machine ID as 9774d56d682e549c and that edge cas is also detected and
assigned a random Uuid.

The other edge case is what happens upon factory reset. That edge case cannot really be handled from the
device so we do not worry about is so rare in a well tested robust application.

The IMEI, deviceID, used in if its an actual phone like device is also hashed.

You will also notice its facytory class to store it in shared preferences and the visibility of variables is limited to maintain
a tight reign in who can see the value of any unencrypted value.

# Usage:

Import the APL into your IDE workspace and in your application:

<code>
    onCreate{
       GWSAndroidUuidFactory myUUId =new DeviceUuidFactory(context);
   }
  </code>

Does not get any simplerr than that folks.

# License

Copyright 2014 Fred Grott GrottWorkShop

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

<a href="http://www.apache.org/licenses/LICENSE-2.0" rel="license">http://www.apache.org/licenses/LICENSE-2.0</a>

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


# Development Resources

As always Google Engineers and OEM Engineers do not answer direct android
application development questions by emial and so these resources are
somewhat better to use for that purpose.

<a href="https://plus.google.com/u/0/communities/105153134372062985968">G+ Android Application Development Circle</a>
<a href="https://plus.google.com/u/0/communities/113499773637471211070">G+ Android Design Circle(private invite only</a>
<a href="http://stackoverflow.com/questions/tagged/android">Stackoverflow Android Area</a>



# About The Author

Fred Grott is an Android Application Engineer that develops android applications
for startups and firms in the Greater Chicago area. His encyclopedia of android
internals and android techniques combined with expert java and computer science
skills and knowledge make short work of tough and challenging development
problems for firms in the Greater Chicago area everything from mobile web applications
to hybrid mobile web and native applications and all the way to android native applications.

Being an Agile Rockstar Android Developer means Fred Grott uses expert java techniques to
choose what methods are effective to solve specific problems. For example, annotations
performance is not robust enough just yet to fully use dependency injection to separate
concerns so modifying MVC into Passive MVC is used to separate concerns such as business logic,
views, and model.

He can be followed on many of his Social Profiles:
<a href="http://goo.gl/M0o50J" rel="me">About.me</a></br>
<a href="http://goo.gl/EmChpW" rel="me">AngelList</a></br>
<a href="http://goo.gl/sEmqJr" rel="me">Behance</a></br>
<a href="http://goo.gl/Mg8r1w" rel="me">BitBucket</a></br>
<a href="http://goo.gl/84p6gA" rel="me">CoderBits</a></br>
<a href="http://goo.gl/lbdx0x" rel="me">CoderWall</a></br>
<a href="http://goo.gl/uun5Qg" rel="me">DeviantArt</a></br>
<a href="http://goo.gl/Vt06L1" rel="me">Dribbble</a></br>
<a href="http://goo.gl/aECSjf" rel="me">Forrst</a></br>
<a href="http://goo.gl/ky9TYK" rel="me">GeekList</a></br>
<a href="http://goo.gl/8wT7LJ" rel="me">GitHub</a></br>
<a href="http://goo.gl/hls95u" rel="me">Gitorious</a></br>
<a href="http://goo.gl/Whf9u3" rel="publisher" rel="me">G Plus</a></br>
<a href="http://goo.gl/2W9e0U" rel="me">HackerNews</a></br>
<a href="http://goo.gl/wCXLYC" rel="me">Html5Ninja</a></br>
<a href="http://goo.gl/7EAFvt" rel="me">LinkedIN</a></br>
<a href="http://goo.gl/sXAS4C" rel="me">MasterBranch</a></br>
<a href="http://goo.gl/xl5cHu" rel="me">Reddit</a></br>
<a href="http://goo.gl/cxs3I2" rel="me">Quora</a></br>
<a href="http://goo.gl/WnemaH" rel="me">SlideShare</a></br>
<a href="http://goo.gl/8y8HDI" rel="me">SpeakerDeck</a></br>
<a href="http://goo.gl/A03BmA" rel="me">StackOverflow</a></br>
<a href="http://goo.gl/TrPn9r" rel="me">ThemeForrest</a></br>
<a href="http://goo.gl/J3dnsA" rel="me">Twitter</a></br>
<a href="http://goo.gl/83Z9aC" rel="me">Udemy</a></br>
<a href="http://goo.gl/kO7g5i" rel="me">YouTube</a></br>

His main websites are:
<a href="http://grottworkshop.blogspot.com/" rel="me">Blog at Blogger</a></br>
<a href="http://goo.gl/ReBZKD" rel="me">GWS site at Github.io</a></br>
<a href="http://goo.gl/D9lo1D" rel="me">AndroidHacker</a></br>

# Contacting Author

The author can be contacted by visiting these profiles and
using the contact links:
<a href"http://goo.gl/M0o50J" rel="me">About.me Profile<a></br>
<a href="http://goo.gl/Whf9u3" rel="me">Google Plus Profile</a></br>

# Endorse The Author

[![endorse](https://api.coderwall.com/shareme/endorsecount.png)](https://coderwall.com/shareme)