# TBPlugin help page

## Unload Spawn

**Performance**  
This option can significantly increase server's performance on weaker systems,
but it comes at a price of spawn region not being "perma loaded"

**Config**  
To enable set `load_spawn` to `false`, the default value is `true` (disabled)

**Description**  
Minecraft always keeps the spawn region loaded no matter where the players are in the world, this lets you disable that "feature". Good for weaker systems and small private servers where players are far (more than 16 chunks) away from spawn

## Tps Command

**Performance**  
No effect

**Config**  
To enable set `tps_command` to `true`, the default value is `false` (disabled)

**Description**  
Adds `/tps` command that displays a following output when executed: `TPS: X, at: Yms (max: 50ms)` where `X` is the tps, and `Y` is the time (in ms) used by the server per tick

## Freeze Empty

**Performance**  
No effect

**Config**  
To enable set `freeze_empty` to `true`, the default value is `false` (disabled)

**Description**  
Sets doDayLightCycle and doWeatherCycle to false when the server is empty, making it so that when you leave the server and return the time and weather will stay unchanged, good for small servers that are often empty, or have only one player at a time
