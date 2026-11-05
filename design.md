This package is my Watchbill Generator project. 
*This page is my notes on what I need to do and how the logic should work.*

Okay. So a watchbill has Watchstations broken up into Watches in assigned timeslots (that can vary between Watchstations), each with an assigned Sailor. The Sailors assigned to the Watch must have the quals that are required for that Watchstation.

The Watchbill Coordinator (WBC) is responsible for making watchbills and this program should be usable and easy to neavigate for them. 

After the Watchstations and their timeslots are set, WBC should be able to manually assign sailors to watches or select a "generate" option to fill empty watches in automatically, and should be able to mix these options. So like they could automatically assign some people to specific watches, then Generate to fill in the empty ones, then change any if needed, and have some highlighting/other indication if someone has been assigned multiple watches. 
The manual input should present an input field that has a text-search that they can type a name in to search through the duty section, then click/enter to fill the name in. Additionally, the names that show up on the dropdown selector before they start typing should be the names of "Preferred Sailors" for that watch. These Preferred Sailors are also how the Generator should logic out how to assign watches. 

A sailor is a Preferred Sailor for a specific watch if they A) have the quals necessary for the watchstation, B) are not OVERqualified for the watchstation (we do not want the system assigning someone that is OOD qualled to a POOW watch unless the duty section is particularly sparse), C) engineers should be preferred for engineering watches and topsiders for topside watches, and D) sailors without gun quals should be used where possible to make sure armed watchstanders are available for armed watches. 

Topsider vs engineer is determined by rate. The best way to determine if a sailor is a topsider or engineer is to have a list of Topside rates and Clown--I mean Engineering Rates, then check the sailor's rate to the lists and assign appropriately.

It should also be noted that for the quarterdeck watches (MOOW, POOW, OOD), either the POOW or OOD must be armed. 

Also, UIs (Under Instruction) watches should be addable by WBC.

**STRUCTURE**
crew is a Set of Sailors
RateList
  checkRate()
DutySection
  int dutySection
  roster<> (ArrayList of Sailors)

Sailor is a class 
  rateList rate
  rankList rank
  name
  deck (topside vs engineer) = checkRate(rate)
  Set<Quals>

  constructor would have (rate, name, deck checkRate(rate), quals[])


  quals would need to come from/be checked against a list

Watchbill is a class
  dutysection
  Watchstations
  Watches
  date

  Allows: 
    Manual assignments
    Automatic generation based on pref. sailors
    Replace assignments
    Add U/I
    Check conflicts


Watchstation is a class
  String name
  Set<Quals> quals
  ArrayList<String> timeslots

  generateWatches() should make the Watches for each timeslot

Watch is a class
  Watchstation watchstation
  String timeslot
  Sailor watchstander
  boolean UI
  preferredSailors[] = findPreferredSailors(roster, currentWatchbill)

enum Quals