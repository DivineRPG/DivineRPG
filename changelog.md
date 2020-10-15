# DivineRPG 1.7.1 changelog:

## Changes:
- Changed the Arcana maze generation algorithm to allow for multiple paths between any two rooms, reducing the chance that the shortest path between two rooms near each other is long-winded and generally making the maze less frustrating
- Slightly increased chance for dead ends to be NPC rooms to compensate for the previous change slightly reducing the amount of dead ends
- Added portal blocks to the creative inventory
- Made twilight dimension boss structures rarer

## Fixes:
- Fixed Dungeon Constructor's death sound being the player hurt sound
- Fixed portal models missing faces and being displayed from the front instead of as blocks
- Fixed placement of Frosted Allure spawns (Nico)
- Fixed mortum ruined portal structure (Velocityraptor)
- Fixed The Eye's potion effect not properly ending

## Miscellaneous:
- Changed the Wildwood Heart texture
- Remove enchanted glint from twilight heart textures

# DivineRPG 1.7 changelog:

## Additions:
- Arcana now generates as an infinite grid of 64x64 chunk mazes. Mazes are made up of a set of many new and redone old rooms placed in order to prevent the player being stuck with no way to proceed (unless the entire 64x64 maze is cleared out, in which case new ones can be accessed with other portals sufficiently far away).
    - IMPORTANT: Due to performance issues with Minecraft's lighting system, the maze is mostly unlit with a few very specific exceptions. Bring torches!
- Added slabs, stairs, and walls for ancient and degraded bricks
- Added a new "dungeon keeper" NPC
- Added breakable variants of several Arcana blocks (purchased from the aforementioned NPC, with breakable brick slabs/stairs/walls craftable from the breakable bricks)
- Added some new blocks:
    - Arcanite Ladder
    - Arcanium Block
    - Dungeon Bookshelf

## Changes:
- Arcana NPCs no longer spawn naturally; instead, they spawn in specific dead-end rooms tailored to them. Each dead end has a flat 1/5 chance to become an NPC room
- Arcana mob spawners are now vanilla spawners and do not use their own block ID
- Arcana mobs now spawn naturally in addition to from spawners (including the Dungeon Constructor)
- Arcana now has a bedrock layer on the top of the ceiling in order to prevent mobs from spawning there (as well as on the bottom for consistency)
- Arcana plants now grow on vanilla farmland like normal plants. They also no longer require tar
- Arcanite Blade and Arcanium Saber now do heavily reduced damage when the required arcana is missing, and consumes more arcana
- Arcanium Metal is now a rotatable pillar block with a different texture on the top
- Collectors are now obtained by crafting 9 Collector Fragments together instead of requiring Lord Vatticus
- Fire resistance now completely nullifies heat trap damage
- Keys are sold by the dungeon keeper for Collectors (they still drop from Dungeon Constructors)
- Moved some trades around between Captain Merik, War General, and Datticon
- Nerfed Heat Trap contact damage and burn time
- Redid Lord Vatticus trades, he now sells various useful vanilla magic items
    - Gave Korma and Vemos armor trades to Captain Merik and War General, respectively
- Removed Orb of Light functionality and made it unobtainable/unused. Like Lamona it caused performance issues and was infeasible without hack-type workarounds
- Removed the "Enrichment" advancement
- Renamed Ancient/Degraded Brick to Ancient/Degraded Bricks for consistency
- Renamed Arcanium Ore to Raw Arcanium and made it a dirt-type block
- Renamed Charged Collector to Collector
- Renamed the old Collector to Collector Fragments
- Some trades now require Collectors instead of Arcanium

------------------

## Other additions:
- Added Frosted Allure block that speeds up mob spawning (Nico)
- Added nuggets for Realmite, Arlemite, Rupee, and Netherite (Nico)
- Added some randomly generating small flavor structures to the twilight dimensions (Nico). Thanks to Velocityraptor for some of the structures

## Other changes:
- Added tooltip to Magic Meat to signify that it is instantly consumed
- Arcana is now hidden when full by default. Can be viewed when full through a config option (Nico)
- Changed Mortum generation to Nether-type with a tar ocean (Nico)
- Decreased regeneration rate of the Arcana resource and removed the slight delay if all arcana is used
- DivineRPG NPCs are no longer vanilla NPCs/villagers. This means they're no longer called "Nitwit" and are excluded from behaviour that checks for villagers (e.g. being attacked by zombies and lightning strikes turning them into witches)
- Ender armor now negates ender pearl damage (Nico)
- Hot pumpkin pie is now cooked from pumpkin pie instead of directly from pumpkins (Nico)
- Iceika dungeon blocks (Icy Bricks and Icy Stone) are no longer unbreakable
    - Added a crafting recipe for Icy Bricks
- Nerfed Mage-type mob fire rate
- Reduce particles spawned by Mage-type mobs and General's Staff
- Removed redundant item durability from all tooltips (use F3+H to view it)
- Removed several unused block textures
- Slightly increased the durability of most armor sets
- The mod's bookshelves are now usable for enchanting like vanilla bookshelves
- Wither reaper armor now withers attackers (Nico)
- Workshop bookcase can now be crafted like a normal bookcase, but with coalstone instead of wood
- Workshop bookcase now drops three books instead of itself unless silk touch is used, for consistency with vanilla

## Fixes:
- Fixed Arcanite Blade doing full damage with or without arcana
- Fixed Arcanium Saber not doing any damage at all if arcana was present
- Fixed Deathcryx having very little health
- Fixed Kazrotic not spawning
- Fixed Wildwood biome name being "WildWood"
- Fixed Wreck having the wrong health value
- Fixed Zone causing an NPE crash
- Fixed axe attack speeds being too high
- Fixed the arcana portal room generating in the middle of other rooms

## Miscellaneous:
- Changed the following textures (thanks to Zachtoplasm):
- Blocks:
    - Ancient Bricks
    - Degraded Bricks
    - Ancient Stone
    - Soul Stone
    - Soul Sludge
    - All Arcana doors
    - Arcanium Power
    - Ancient Tile
    - Heat Trap (on/off)
    - Arcanium Metal
    - Arcana Portal
    - Arcanite Tubes
    - Raw Arcanium
    - Dungeon Lamp
- Items:
    - Arcanium
    - Collector
    - Collector Fragments

# DivineRPG 1.6.4.1 changelog:

## Additions:
- Added Just Enough Resources support (Nico)

## Changes:
- Rewrote how structures are generated. This should fix various issues, including structure rarity and distribution (especially in twilight dimensions and Iceika)
- Made twilight structures generate more commonly
- Structures are now randomly rotated and will not all face the same way anymore
- Added loot chests to some Iceika houses that did not previously have them
- Renamed tar to smoldering tar, fixing a Betweenlands tar conflict and putting emphasis on the tar's high temperature
- Made Iceika trees generate a bit more sparsely
- Twilight boss spawners now require chunks to activate
- Statues make sounds on right click (Locomen)
- Changed water mob AI (Nico)
- Made whales shoot out water spouts when above sea level (Nico)

## Fixes:
- Made Arcana boss altars generate again
- Gave mortum back its bedrock layer
- Fixed empty loot chests in Iceika houses
- Made change to flying mob attack target getter (Nico)

## Miscellaneous:
- Changed the following textures:
    - Corrupted Shards
    - Ender Shards
    - Snow Globe
    - Sound of Music
    - Sound of Carols


# DivineRPG 1.6.4 changelog:

## Changes:
- Organized dimensional advancements into their own sections.
- Added advancements for Vethea
- Renamed some advancements
- Removed the mod's duplicate nether and end entry advancements. The mod's nether and end advancements are now in their respective vanilla sections
- NPC advancements now require trading with them instead of just speaking with them
- Made advancement IDs correspond to their English names instead of the general task
- Merged the ayeraco horde advancements into a single one for defeating all five of them
- Frozen Goods advancement now requires obtaining a snowflake instead of breaking a frosted chest
- Boss advancements no longer give out statues when obtained
- Changed boss statue drop rate to 100%
- Twilight boss spawners are now reusable. No more need to find multiple structures
- Added a configuration option to disable player hats
- Halite armor can now be repaired with mortum chunks
- Swapped halite drops of Eternal Archer (now drops bow and blitz) and Twilight Demon (now drops helmet and boots) for consistency and ease of obtaining halite armor
- Made most Vethean structures slightly more common
- Removed throwable Lamona because it caused lag and Minecraft's lighting system isn't meant to handle light from entities
- Made rive and aftershock registry names match their English names

## Fixes:
- Fixed the vethean crypts generating with grass in them
- Fixed pick block not working for mod doors and nightmare bed
- Fixed grenade and corrupted bullet missing textures
- Fixed Hive Queen not dropping anything
- Fixed the Hunger's trades not being infinite

## Miscellaneous:
- Changed several item textures:
   - All Twilight Souls
   - All Shards (except Corrupted and Ender)
   - Shuriken
   - Snowflake Shuriken
   - Vile Storm
   - Liopleurodon Teeth
   - Moonbulb
   - Sunstorm Heart
   - Corrupted Maul
- Capitalised Eden biome name
- Stopped root advancement from announcing itself in chat whenever joining a world for the first time

# 1.6.3.1 - Patch update

## Changes:
- Fixed cyclops, glacide, and jack-o-man renders
- Fixed Vamacheron statue texture
- Fixed ever arrows being unobtainable (now purchased from the Hunger)
- Gave all mobs shadows for consistency
- Removed netherite ore contact damage and cactus effect

# 1.6.3 changelog
## Additions
- Added Experienced Cori (Nico). Drops the halite shield
- Added structures for Experienced Cori and Eternal Archer in Skythern and Apalachia, respectively (Nico). Thanks to Velocityraptor for Experienced Cori structure
- Added twilight shields (Nico). Thanks to Linx145 for shield textures

## Changes
- Rebalanced armor to use the vanilla armor point/armor toughness system
    - All mod armor now has finite durability, and the ones that already did generally have lower durability
    - Removed redundant durability display from the mod's armor tooltips. Use F3+H (vanilla Minecraft feature) to view durability
    - Buffed most overworld and twilight mobs to increase their efficacy against low toughness armor
    - Nerfed advanced cori from 100 damage to 60 damage. 100 doesn't work well with armor toughness in the slightest
- Moved Eternal Archer to Apalachia as its progression boss (Nico)
- Twilight hearts are now guaranteed drops of 1-4 from their bosses (can still be increased with looting)
- Mortum bosses now drop mortum hearts (Nico)
- Nerfed ender triplet damage and explosion power slightly
- Removed end portal frame drop from ender triplets. Now it drops ender eyes instead
- Changed certain configuration features to be compatible with Forge's built-in configuration GUI
- Removed various unused configuration options
- Added option to disable welcome messages in config
- You can now use bone meal on grass blocks that have their own ground foliage (like twilight dimension grass)
- Removed the harvest level requirements on most decorative blocks
- Rewrote forbidden fruit and changed its effect
- Reworked advancements (Loco)
- Slight tweaks to Sunstorm AI (Nico)
- Added more EMC values and ore dictionary entries (Nico)

## Fixes
- Fixed the update checker
- Rewrote rive/world break, should hopefully fix any issues it had
- Fixed the 1024 maximum health patch, and consequently the health amounts of bosses that are supposed to have more than 1024 health
- Fixed armor flight being present when it shouldn't be (Dash)
- Fixed ammo tooltip (Nico)
- Fixed doors not dropping themselves even when broken with the correct tool
- Fixed colored chat messages not actually being colored
- Bone meal is no longer usable on grass blocks that don't have their own ground foliage

## Miscellaneous
- Renamed "Herbalism" creative tab to "Food and Agriculture"
- Remove "DivineRPG dev team" message on boot
- Remove generic "Welcome <playername>" message
- Tweaks to mcmod.info, it also displays the mod logo now

# 1.6.2.1 changelog
## Changes
- Tweaked boss bar colors (Nico)
- Removed water mob spawns to fix a bug (Astral)

## Fixes
- Bosses got chiropractor and now have animations (Nico)
- Fixed iceika chests not always having loot (Nico)

## Known bugs
- Water mobs dont spawn

# 1.6.2 changelog

## Additions
- Simplified chinese localization (MCUmbrella)
- Aftershock Enchant (Dash)
- New boss statues (Dash)

## Changes
- Sunstorm no longer drops forbidden fruit (Astral)
- Lowered Sunstorm projectile count (Astral)
- Boss spawn cages have a small delay (Dash)
- Buffed pumpkin pie (Astral)
- Made Termasect 5x larger (Nico)
- Better render on Termasect log (Nico)
- Buffed Termasect (Nico)
- Redesigned the Termasect dungeon (VelocityRaptor)
- Complete rewrite of spawn cages (Dash)
- New bosses drop fragments instead of chunks (Nico)
- Buffed King of Scorchers (Dash)
- Renamed world break enchant to Rive (Nico)

## Fixes
- Fixed Termasect spawning Termid (Astral)
- Fixed shuriken recipe (Nico)
- Fixed Enchanted Archer (Dash)
- Fixed mortum ore spawns (Dash)
- Fixed arcanite blaster model (Nico)

## Known bugs
- Iceika Chests dont always have loot

# 1.6.1 changelog
## Additions
- Sunstorm/Termid/Termasect (Nico)

## Changes
- Eden/Wildwood both require killing the new bosses to progress (Nico)

## Known bugs
- Iceika Chests don't always have loot

## Credits
- Velocityraptor for the general design of the sunstorm temple

## 1.6.0.2 changelog

## Additions
- Rupee shield (Nico)
- Donut recipe (Dash)

## Changes
- More XP for killing Ancient Entity (Nico)
- Shadow armor has step assist (Nico)
- Mob stats are config options (Dash)

## Fixes
- Fixed ayeraco Crash (Dash)
- Fixed arcana crash (Dash)
- Fixed sapling model (Nico)
- Fixed armor repair materials (Astral)

## Compatability
- Fixed reliquary compat (Dash)

## Known bugs
- Iceika chests dont always have loot

# 1.6.0.1 changelog
## Additions
- Added empty loot tables to remove log errors (Astral)
- Check for fake player before sending arcana packet (Astral)

## Fixes
- Fixed crash that makes Vethea unplayable (Astral)
- Changed vethea portal event to compare ints to fix DimensionType crash with mods that don't use it, such as Mystcraft (Astral)

## Known bugs
- Iceika Chests don't always have loot

# 1.6 changelog

## Additions
- Added Frozen Charge to blow down Arcana walls (Nico 1.12.2, ported from Eternaldoom's new 1.7.10 version).
- Added Shields (Dash). Credits to Linx145 for shield textures.
- Added frozen sapling (Dash)
- Added AOE digging enchantment "World Breaker". 3 levels (3x3x1, 3x3x2, 3x3x3). Can be applied to all digging tools (Dash)
- Added Hive Egg, which spawns Hive Queen and disappears when right-clicked (Astral)
- Readded barred door, which disappeared in 1.5.0 (Astral)
- Added teleportation star (Dash)
- Added dream tools to Vethea that cost clean pearls (Astral)

## Changes
- Tweaks to translations (Locomen)
- Removed "War" and "Wrath" from names of vethean god weapons, they were just causing issues (Astral)
- Renamed Karos Cannon block to Karos Dispenser (Astral)
- Something for the testers (Nico)
- Colored statues (Dash)
- Tweaked brick recipes as per Martin414's request (Nico)
- Iceika optimizations (Dash)
- Redid Vethea generation system. New system no longer has cascading generation and should generate faster, especially once already in the dimension (Dash)
- Added loot chests to the following Vethean structures. Loot them for extra resources:
- Crypt (both variants)
- Temple (both variants)
- Karos Madhouse
- Quadrotic Post
- Raglok Chamber
- Wreck Hall
- Removed the old giant floating Hunger Village, it was causing issues and was hard to work with, among other things. The Hunger now spawns in floating houses that spawn semi-commonly in layer 1, which ideally makes them easier to find. (Astral)
- Redid Quadrotic Post completely. It's now more like a small arena then a tiny staircase (Astral)
- Replaced Wreck Hall acid with lava moat (Astral)
- Hive Nest now starts with a Hive Egg block instead of spawning Hive Queen directly, to prevent issues (Astral)
- Changed some textures (LiteWolf101)
- Updated lang system (Dash/Locomen_)
- Changed default Iceika dimension ID to be more in line with the others (Astral)

## Fixes
- Fixed infusion table recipes not working (Astral)
- Fixed plants from crashing the game when planted (Dash)
- Fixed armor (Dash)
- Fixed Doors (Nico)
- Fixed passive until mobs not attacking after players death (Nico)
- Fixed Mortum trees (Nico)
- Fixed Dev Hat/Added Tester hat (Dash)
- Fixed Brittle leaves (Dash)
- Fixed issue with automated boss machines and fake players (Dash)
- Fixed Shickaxes (Dash)
- Fixed Saturation values (Astral)
- Optimized flying mob AI (Dash)
- Fixed tool repairing not working (Astral)
- Fixed bedrock sword still having bedrock as repair material instead of bedrock chunks (Astral)
- Fixed twilight tools having absurdly high harvest levels (Astral)
- Fixed missing vethea spawns (Astral)

 ## Compatability
- Fixed Apotheosis issue (Dash)
- Fixed arcana bar coloring for mod compatability (TimeConqueror)

# 1.5.2 changelog

## Fixes:
- Fixed plants spawning as dropped items in dimensions (Astral)
- Fixed all bows/ranged weapons having infinite ammunition (Astral)
- Fixed Skythern Fiend model (Dash)
- Fixed incorrect internal version number (Astral)
- Fixed blockstate console spam (NicosaurusRex99)

## Additions:
- Added firecrystal generation to Vethea (Astral)
- Added frozen, eucalyptus, and divine stairs (Astral)

## Other:
- Updated russian translation (kellixon)

# 1.5.1 changelog
- Fixed megalith texture
- Fixed Dreamwrecker bad cast

# 1.5 changelog
- Ported to 1.12.2
