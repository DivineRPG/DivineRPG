package divinerpg.enums;

public enum EntityStats {
    //Default
    DEFAULT(),

    //Bosses
    ANCIENT_ENTITY(800, 12, 64),
    AYERACO(600, 1, 64),
    DENSOS(1000, 30, 64),
    DRAMIX(1400, 30, 64),
    ETERNAL_ARCHER(1550, 12, 64),
    EXPERIENCED_CORI(1150, 26, 64),
    KITRA(750, 8, 64),
    HIVE_QUEEN(1500, 60, 64),
    KAROS(4000, 20, 64),
    KAROT(1250, 32, 64),
    KING_OF_SCORCHERS(1100, 22, 64),
    LADY_LUNA(8000, 20, 64),
    PARASECTA(1000, 22, 64),
    QUADRO(4000, 12, 64),
    RAGLOK(5000, 30, 64),
    REYVOR(1000, 28, 64),
    SOUL_FIEND(1100, 26, 64),
    SUNSTORM(1000, 18, 64),
    TERMASECT(1050, 20, 64),
    THE_WATCHER(950, 12, 64),
    TWILIGHT_DEMON(1600, 30, 64),
    VAMACHERON(1350, 34, 64, .405),
    WRECK(5000, 30, 64),

    //Overworld
    AEQUOREA(4, 3, 4, .135),
    ARID_WARRIOR(40, 8),
    CAVE_CRAWLER(30, 4),
    CAVECLOPS(60, 6),
    CRAB(45, 6),
    CYCLOPS(35),
    DESERT_CRAWLER(40, 6),
    ENTHRALLED_DRAMCRYX(80, 7),
    FROST(25, 6),
    GLACON(35, 7, 20, .432),
    JUNGLE_BAT(),
    JUNGLE_DRAMCRYX(40, 7),
    JUNGLE_SPIDER(45, 7),
    KING_CRAB(100, 9),
    KOBBLIN(35, 7),
    LIOPLEURODON(150, 13),
    MINER(40),
    PUMPKIN_SPIDER(50, 7, 25),
    RAINBOUR(100, 18),
    ROTATICK(30, 6),
    SAGUARO_WORM(80, 4, 20, 0),
    SHARK(80, 8),
    THE_EYE(40, 10),
    THE_GRUE(30, 10, 20, .31),
    WHALE(120, 10),

    //Livestock Merchant Pets
    EHU(60),
    GRIZZLE(100, 9, 20, .29),
    HUSK(80, 10),
    SMELTER(120, 7),
    SNAPPER(150, 4, 20, .285),
    STONE_GOLEM(100),

    //Nether
    HELL_PIG(50, 5),
    HELL_SPIDER(50, 8),
    SCORCHER(75),
    WILDFIRE(50, 8),

    //End
    END_SPIDER(35, 12),
    ENDER_SCROUNGE(10, 1, 32),
    ENDER_TRIPLETS(10),
    ENDER_WATCHER(50, 11),

    //Iceika
    CAULDRON_FISH(6, 3, 4, .135),
    GHOST_GLIDER(5, 2, 4, .125),
    BLUBBERTUSK(35, 4),
    ROBBIN(4, .5),
    SNOW_SKIPPER(6),
    WOLPERTINGER(12, 2),
    DOLOSSAL(30, 1, 20, .33),
    MAMOTH(40, 8, 20, .2),
    FRACTITE(30),
    ROLLUM(70, 11, 20, .3),
    PALE_ARCHER(25, 2),
    FROZEN_FLESH(30, 6, 20, .35),
    ALICANTO(35, 7),
    SABEAR(40, 11),
    SENG(35, 9, 10, .33),
    HASTREUS(100, 15),
    GLACIDE(60, 12, 20, .48),

    //Groglins
    GROGLIN(40, 2, 20, .31),
    GROGLIN_CHIEFTAIN(50, 2, 20, .31),
    GROGLIN_RANGER(40, 2, 20, .31),
    GROGLIN_SHARLATAN(50, 2, 20, .31),
    GROGLIN_WARRIOR(40, 2, 20, .31),

    //Gruzzorlugs
    GRUZZORLUG(60, 2, 20, .29),
    GRUZZORLUG_COMMANDER(70, 2, 20, .29),
    GRUZZORLUG_GENERAL(70, 2, 20, .29),
    GRUZZORLUG_KNIGHT(50, 2, 20, .29),
    GRUZZORLUG_SWORDSMAN(60, 2, 20, .29),

    //Arcana
    DEATH_HOUND(120, 12),
    DEATHCRYX(160, 14),
    DUNGEON_CONSTRUCTOR(100, 19),
    DUNGEON_PRISONER(85, 17),
    LIVING_STATUE(60),
    RAZORBACK(35, 9),
    ROAMER(),
    SKYRE(35, 8, 16),
    FYRACRYX(60, 5),
    GOLEM_OF_REJUVENATION(30, 2),
    PARATIKU(100),
    SEIMER(150, 1.5),
    WRAITH(150),

    //Eden
    EDEN_TOMO(96, 16),
    EDEN_CADILLION(120, 18),
    GEM_FIN(3),
    GLINTHOP(10, 12),
    GREENFEET(200, 22),
    MADIVEL(150, 20),
    SUN_ARCHER(72, 15),
    WEAK_CORI(10, 30),

    //Wildwood
    BEHEMOTH(180, 16),
    EPIPHITE(100, 16),
    MAGE(90, 12),
    MOON_WOLF(130, 12),
    TERMID(50, 12),
    VEREK(78, 18),
    WILDWOOD_CADILLION(130, 20),
    WILDWOOD_GOLEM(200, 23),
    WILDWOOD_TOMO(110, 18),

    //Apalachia
    APALACHIA_CADILLION(145, 22),
    APALACHIA_GOLEM(200, 24),
    APALACHIA_TOMO(116, 20),
    ENCHANTED_ARCHER(87),
    ENCHANTED_WARRIOR(87, 2),
    SPELLBINDER(100, 14),

    //Skythern
    ADVANCED_CORI(35, 100),
    MEGALITH(310, 25, 20, .25),
    MYSTIC(120, 12),
    SAMEK(160, 23),
    SKYTHERN_ARCHER(124),
    SKYTHERN_FIEND(155, 24),
    SKYTHERN_GOLEM(248, 25),

    //Mortum
    ANGRY_GLINTHOP(96, 23),
    BASILISK(300, 23),
    DEMON_OF_DARKNESS(200, 24),
    MORTUM_CADILLION(165, 26),
    SORCERER(132, 14),
    SOUL_SPIDER(64, 21),
    SOUL_STEALER(140, 26),
    TWILIGHT_ARCHER(96),

    //Vethea
    //Layer 1
    CRYPT_KEEPER(200, 1, 25, .32),
    MYSTERIOUS_MAN(20, 1, 35, .32),
    ACID_HAG(25),
    CYMESOID(25, 8),
    DREAMWRECKER(60, 8),
    DUO(20, 7, 20, .32),
    ENT(50, 20),
    HIVE_SOLDIER(20, 6),
    HOVER_STINGER(20, 4, 35, .32),
    LORGA(15, 4),
    SHADAHIER(10, 7),

    //Layer 2
    TEMPLE_GUARDIAN(),
    BIPHRON(40, 14),
    GORGOSION(60),
    MANDRAGORA(35),
    TWINS(10),
    VERMENOUS(100, 14),

    //Layer 3
    BOHEMITE(60, 13, 20, .36),
    GALROID(100, 25),
    KAZROTIC(65, 1),
    LHEIVA(85, 22),
    LORGA_FLIGHT(40, 8),
    TOCAXIN(65, 13),

    //Layer 4
    DISSIMENT(70),
    HELIO(140, 40),
    VHRAAK(100, 30),
    ZONE(120),
    ZORAGON(110, 0, 35, .09);

    final double health, attackDamage, followRange, movementSpeed;
    public static final double normalHealth = 20, normalDamage = 1, normalSpeed = .27, normalFollowRange = 20;
    EntityStats() {
        health = normalHealth;
        attackDamage = normalDamage;
        followRange = normalFollowRange;
        movementSpeed = normalSpeed;

    }
    EntityStats(double health) {
        this.health = health;
        attackDamage = normalDamage;
        followRange = normalFollowRange;
        movementSpeed = normalSpeed;

    }
    EntityStats(double health, double attackDamage) {
        this.health = health;
        this.attackDamage = attackDamage;
        followRange = normalFollowRange;
        movementSpeed = normalSpeed;

    }
    EntityStats(double health, double attackDamage, double followRange) {
        this.health = health;
        this.attackDamage = attackDamage;
        this.followRange = followRange;
        movementSpeed = normalSpeed;

    }
    EntityStats(double health, double attackDamage, double followRange, double movementSpeed) {
        this.health = health;
        this.attackDamage = attackDamage;
        this.followRange = followRange;
        this.movementSpeed = movementSpeed;

    }
    public double getHealth() {return health;}
    public double getAttackDamage() {return attackDamage;}
    public double getFollowRange() {return followRange;}
    public double getMovementSpeed() {return movementSpeed;}
}