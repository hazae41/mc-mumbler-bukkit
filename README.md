# Mumbler for Bukkit

Only players who can physically hear you will see your messages.

#### [Download Mumbler](https://github.com/saurusmc/mumbler-bukkit/raw/master/build/libs/mumbler-1.2.jar)

### Features

- No configuration needed, no permissions
- Supports English, French, Spanish, Italian, Portuguese, German, Dutch, Russian, Polish, Japanese and Simplified
  Chinese
- Talking ranges from 50 to 100 blocks
- Shouting ranges from 100 to 200 blocks
- You can shout by adding "!" at the end of your message
- Shouting will cost you 1 half-heart, so only do it when necessary
- Ranges are calculated according to sender direction and recipient direction:
    - If both are looking at each other, the range will be maximal (100)
    - If only the sender is looking at the receiver, the range will be good (~90)
    - If only the receiver is looking at the sender, the range will be bad (~60)
    - If both turn their back, the range will be minimal (50)
- You can see who seen your message by hovering it
  ![](https://i.gyazo.com/40b743ffeb3ad50791c733d88b721b00.png)
