package PROJECT;

import java.util.ArrayList;

public class Classes {
  class Sailor {
    String name;
      Rates rate;
      Paygrade paygrade;
        boolean isKhaki = paygrade.isKhaki();
    Quals[] quals;
  }

  // Need to figure out how to organize this. I think Watch should be a class, with properties Time and WatchStation. The WatchStation should be a... an enum? Except it also needs to have a list of required quals and preferred sailors. So maybe WatchStation should be a class, with properties Name, RequiredQuals, and PreferredSailors. Then Watch can have properties Time and WatchStation. Then the Watchbill can be a list of Watches. I don't know for sure.
  // class WatchStation {
  //   Quals[] requiredQuals;
  //   ArrayList<Sailor> preferredSailors;
  // }
}

enum Quals {
  CommandDutyOfficer,
  SectionLeader,
  DutyMasterAtArms,
  WatchbillCoordinator,

  OfficerOfTheDeck,
  PettyOfficerOfTheWatch,
  MessengerOfTheWatch,
  SRF_A,
  SRF_B,

  DamageControl,
  AdvancedDamageControl,
  TeamLeader,
  AdvancedMedical,
  AFFFOperator,
  SoundingAndSecurity,
  FireSafetyWatch,
  RepairPartyInvestigator;
}

//#region Rating and Paygrade Enums
enum Area {
  TOPSIDE,
  ENGINEERING,
}

enum Rates {
  CTR(Area.TOPSIDE),
  CTT(Area.TOPSIDE),
  CTI(Area.TOPSIDE),
  CTM(Area.TOPSIDE),
  BM(Area.TOPSIDE),
  OS(Area.TOPSIDE),
  QM(Area.TOPSIDE),
  IS(Area.TOPSIDE),
  IT(Area.TOPSIDE),
  ITS(Area.TOPSIDE),
  IC(Area.TOPSIDE),
  STG(Area.TOPSIDE),
  FC(Area.TOPSIDE),
  FCA(Area.TOPSIDE),
  GM(Area.TOPSIDE),
  YN(Area.TOPSIDE),
  PS(Area.TOPSIDE),
  CS(Area.TOPSIDE),
  RS(Area.TOPSIDE),
  LS(Area.TOPSIDE),
  EM(Area.ENGINEERING),
  ET(Area.TOPSIDE),
  MM(Area.ENGINEERING),
  DC(Area.ENGINEERING),
  HT(Area.ENGINEERING),
  MR(Area.ENGINEERING),
  GSE(Area.ENGINEERING),
  GSM(Area.ENGINEERING);

  final Area area;

  Rates(Area area) {
    this.area = area;
  }
}

enum PersonnelCategory {
  ENLISTED,
  WARRANT,
  OFFICER,
}

enum Paygrade {
  E1(PersonnelCategory.ENLISTED, 1),
  E2(PersonnelCategory.ENLISTED, 2),
  E3(PersonnelCategory.ENLISTED, 3),
  E4(PersonnelCategory.ENLISTED, 4),
  E5(PersonnelCategory.ENLISTED, 5),
  E6(PersonnelCategory.ENLISTED, 6),
  E7(PersonnelCategory.ENLISTED, 7),
  E8(PersonnelCategory.ENLISTED, 8),
  E9(PersonnelCategory.ENLISTED, 9),

  W1(PersonnelCategory.WARRANT, 1),
  W2(PersonnelCategory.WARRANT, 2),
  W3(PersonnelCategory.WARRANT, 3),
  W4(PersonnelCategory.WARRANT, 4),
  W5(PersonnelCategory.WARRANT, 5),

  O1(PersonnelCategory.OFFICER, 1),
  O2(PersonnelCategory.OFFICER, 2),
  O3(PersonnelCategory.OFFICER, 3),
  O4(PersonnelCategory.OFFICER, 4),
  O5(PersonnelCategory.OFFICER, 5),
  O6(PersonnelCategory.OFFICER, 6),
  O7(PersonnelCategory.OFFICER, 7),
  O8(PersonnelCategory.OFFICER, 8),
  O9(PersonnelCategory.OFFICER, 9);

  final PersonnelCategory category;
  final int grade;

  Paygrade(PersonnelCategory category, int grade) {
    this.category = category;
    this.grade = grade;
  }

  boolean isKhaki() {
    return category != PersonnelCategory.ENLISTED
        || grade >= 7;
  }
}
//#endregion