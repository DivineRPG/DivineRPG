package divinerpg.enums;

public enum EntityStats {
    //DEFAULT
    DEFAULT(),

    //BOSS
    ANCIENT_ENTITY(800, 12),
    AYERACO(600),
    DENSOS(1000, 30),
    DRAMIX(1400, 30),
    ETERNAL_ARCHER(1550, 12),
    EXPERIENCED_CORI(1150, 26),
    KITRA(750, 8),
    HIVE_QUEEN(1500, 60),
    KAROS(4000, 20),
    KAROT(1250, 32),
    KING_OF_SCORCHERS(1100, 22),
    LADY_LUNA(8000, 20),
    PARASECTA(1000, 22),
    QUADRO(4000, 12),
    RAGLOK(5000, 30),
    REYVOR(1000, 28),
    SOUL_FIEND(1100, 26),
    SUNSTORM(1000, 18),
    TERMASECT(1050, 20, 64),
    THE_WATCHER(950, 12),
    TWILIGHT_DEMON(1600, 30),
    VAMACHERON(1350, 34, 20, 0.4050000062584877),
    WRECK(5000, 30),

    //OVERWORLD
    AEQUOREA(4, 3, 4, 0.135),
    ARID_WARRIOR(40, 8),
    ENTHRALLED_DRAMCRYX(80, 7),
    CAVECLOPS(60, 6),
    CAVE_CRAWLER(30, 4),
    CRAB(45, 6),
    CYCLOPS(35),
    DESERT_CRAWLER(40, 6),
    FROST(50, 6),
    GLACON(60, 7, 20, 0.432),
    JUNGLE_DRAMCRYX(40, 7),
    JUNGLE_BAT(),
    JUNGLE_SPIDER(45, 7),
    RAINBOUR(100, 18),
    KING_CRAB(100, 9),
    ROTATICK(30, 6),
    SHARK(80, 8),
    THE_EYE(40, 10),
    WHALE(120, 10),
    LIOPLEURODON(150, 13),
    KOBBLIN(35, 7),
    THE_GRUE(30, 10, 20, 0.31),
    SAGUARO_WORM(80, 4, 20, 0),
    PUMPKIN_SPIDER(50, 7),
    EHU(60),
    HUSK(80, 10),
    STONE_GOLEM(100),
    SMELTER(120, 7),
    GRIZZLE(100, 9, 20, 0.29),
    SNAPPER(150, 4, 20, 0.285),
    MINER(40),

    //NETHER
    HELL_PIG(50, 5),
    HELL_SPIDER(50, 8),
    SCORCHER(75),
    WILDFIRE(50, 8),

    //END
    END_SPIDER(35, 12),
    ENDER_SCROUNGE(10, 1, 32),
    ENDER_TRIPLETS(10),
    ENDER_WATCHER(50, 11),

    //ICEIKA
    BLUBBERTUSK(60, 4),
    CAULDRON_FISH(10, 3, 4, 0.135),
    DOLOSSAL(40, 1, 20, .33),
    ALICANTO(75, 11),
    FRACTITE(50),
    PALE_ARCHER(40, 2),
    GLACIDE(80, 12, 20, 0.48),
    HASTREUS(120, 16),
    ROLLUM(150, 12, 20, 0.30),
    FROZEN_FLESH(140, 16, 20, 0.35),
    SABEAR(60, 12),
    WOLPERTINGER(15, 2),
    ROBBIN(2, 0.5),
    SENG(55, 4, 10, 0.33),
    //Groglin
    GROGLIN(40, 3, 20, .31),
    GROGLIN_CHIEFTAIN(50, 8, 20, .31),
    GROGLIN_RANGER(40, 3.5, 20, .31),
    GROGLIN_SHARLATAN(50, 3, 20, .31),
    GROGLIN_WARRIOR(40, 6, 20, .31),
    //Gruzzorlug
    GRUZZORLUG(60, 3, 20, 0.29),
    GRUZZORLUG_COMMANDER(70, 3, 20, 0.29),
    GRUZZORLUG_GENERAL(70, 7, 20, 0.29),
    GRUZZORLUG_KNIGHT(50, 7.5, 20, 0.29),
    GRUZZORLUG_SWORDSMAN(60, 4, 20, 0.29),

    //EDEN
    GLINTHOP(10, 12),
    EDEN_TOMO(96, 16),
    EDEN_CADILLION(120, 18),
    GEM_FIN(3),
    GREENFEET(200, 22),
    MADIVEL(150, 20),
    SUN_ARCHER(72, 15),
    WEAK_CORI(10, 30),

    //WILDWOOD
    BEHEMOTH(180, 16),
    EPIPHITE(100, 16),
    MAGE(90, 12),
    MOON_WOLF(130, 12),
    TERMID(50, 12),
    VEREK(78, 18),
    WILDWOOD_CADILLION(130, 20),
    WILDWOOD_GOLEM(200, 23),
    WILDWOOD_TOMO(110, 18),

    //APALACHIA
    APALACHIA_CADILLION(145, 22),
    APALACHIA_GOLEM(200, 24),
    APALACHIA_TOMO(116, 20),
    ENCHANTED_ARCHER(87),
    ENCHANTED_WARRIOR(87, 22),
    SPELLBINDER(100, 14),

    //SKYTHERN
    ADVANCED_CORI(35, 100),
    MEGALITH(310, 25, 20, 0.25),
    MYSTIC(120, 12),
    SAMEK(160, 23),
    SKYTHERN_ARCHER(124),
    SKYTHERN_FIEND(155, 24),
    SKYTHERN_GOLEM(248, 25),

    //MORTUM
    ANGRY_GLINTHOP(96, 23),
    BASALISK(300, 23),
    DEMON_OF_DARKNESS(200, 24),
    MORTUM_CADILLION(165, 26),
    SORCERER(132, 14),
    SOUL_SPIDER(64, 21),
    SOUL_STEALER(140, 26),
    TWILIGHT_ARCHER(96),

    //ARCANA
    PARATIKU(100),
    SEIMER(150),
    VERMSILLION(30),
    RAZORBACK(35, 9),
    SKYRE(35, 8, 16),
    LIVING_STATUE(60),
    GOLEM_OF_REJUVENATION(30, 2),
    FYRACRYX(60, 5),
    DUNGEON_PRISONER(85, 17),
    DEATH_HOUND(120, 12),
    DEATHCRYX(160, 14),
    DUNGEON_CONSTRUCTOR(100, 19),
    WRAITH(150),
    ROAMER(),

    //VETHEA
    CRYPT_KEEPER(200, 1, 25, 0.32),
    BOHEMITE(60, 13, 20, 0.36),
    BIPHRON(40, 14),
    ACID_HAG(25),
    CYMESOID(25, 8),
    GALROID(100, 25),
    ENT(50, 20),
    DISSIMENT(70),
    DREAMWRECKER(60, 8),
    DUO(20, 7, 20, 0.32),
    GORGOSION(60),
    HELIO(140, 40),
    HERBOMANCER(40),
    HERMOBANCER_MINION(10),
    HIVE_SOLDIER(20, 6),
    HOVER_STINGER(20, 4, 35, 0.32),
    KAZROTIC(65, 1),
    LHEIVA(85, 22),
    LORGA(15, 4),
    LORGA_FLIGHT(40, 8),
    MANDRAGORA(35),
    MYSTERIOUS_MAN(20, 1, 35, 0.32),
    SHADAHIER(10, 7),
    TEMPLE_GUARDIAN(),
    TOCAXIN(65, 13),
    TWINS(10),
    VERMENOUS(100, 14),
    VHRAAK(100, 30),
    ZONE(120),
    ZORAGON(110, 0, 35, 0.09)
    ;



    final double health, attackDamage, followRange, movementSpeed;
    public static final double normalHealth = 20D, normalDamage = 1D, normalSpeed = .27000000417232513, normalFollowRange = 20D;

    EntityStats() {
        this.health = normalHealth;
        this.attackDamage = normalDamage;
        this.followRange = normalFollowRange;
        this.movementSpeed = normalSpeed;

    }
    EntityStats(double health) {
        this.health = health;
        this.attackDamage = normalDamage;
        this.followRange = normalFollowRange;
        this.movementSpeed = normalSpeed;

    }

    EntityStats(double health, double attackDamage) {
        this.health = health;
        this.attackDamage = attackDamage;
        this.followRange = normalFollowRange;
        this.movementSpeed = normalSpeed;

    }

    EntityStats(double health, double attackDamage, double followRange) {
        this.health = health;
        this.attackDamage = attackDamage;
        this.followRange = followRange;
        this.movementSpeed = normalSpeed;

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