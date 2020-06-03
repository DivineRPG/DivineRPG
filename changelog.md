# 1.6.3.1 - Patch update

## Changes:
- Fixed cyclops, glacide, and jack-o-man renders
- Fixed Vamacheron statue texture
- Fixed ever arrows being unobtainable (now purchased from the Hunger)
- Gave all mobs shadows for consistency
- Removed netherite ore contact damage and cactus effect

# 1.6.3 changelog
Additions
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
