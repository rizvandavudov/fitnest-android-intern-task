# FitNest Asset Inventory

This document lists the raster images and vector icons required to implement
the Home and Profile screens from the provided Figma design.

## Asset rules

- Full-screen screenshots must not be used as UI.
- Temporary Figma asset URLs must not be used in application code.
- Raster content images will be loaded through Coil using stable hardcoded URLs.
- Exact Figma vector assets will be used unless a Compose/Material icon is
  visually identical to the Figma glyph.
- Asset filenames use lowercase semantic snake_case.
- iOS status bar icons and the iOS home indicator are reference-only and will
  not be included as Android application assets.

## Raster assets

### Home — category images

| Filename | Theme | Content |
|---|---|---|
| `home_category_fitness_light.webp` | Light | Fitness |
| `home_category_fitness_dark.webp` | Dark | Fitness |
| `home_category_pilates_light.webp` | Light | Pilates |
| `home_category_pilates_dark.webp` | Dark | Pilates |
| `home_category_combat_light.webp` | Light | Döyüş növləri |
| `home_category_combat_dark.webp` | Dark | Döyüş növləri |
| `home_category_yoga.webp` | Shared | Yoga |
| `home_category_spa_massage.webp` | Shared | Spa və masaj |
| `home_category_cosmetology.webp` | Shared | Kosmetoloji |

The first three category images differ between the Light and Dark Figma
variants. The remaining images are shared.

### Home — FitMarket product images

| Filename | Theme | Content |
|---|---|---|
| `home_product_vitamin_house.webp` | Shared | Primary FitMarket product |
| `home_product_secondary.webp` | Shared | Secondary FitMarket product |

### Home — gym images

| Filename | Theme | Content |
|---|---|---|
| `home_gym_pulse_primary_light.webp` | Light | First Pulse Gym image |
| `home_gym_pulse_secondary_light.webp` | Light | Second Pulse Gym image |
| `home_gym_pulse_tertiary_light.webp` | Light | Third Pulse Gym image |
| `home_gym_pulse_dark.webp` | Dark | Dark-theme Pulse Gym image |

The Dark Figma design reuses the same gym raster in multiple cards.

### Profile

| Filename | Theme | Content |
|---|---|---|
| `profile_avatar.webp` | Shared | Profile avatar |

The same visible avatar will be used for Light and Dark themes. The additional
background image fill found behind the Dark avatar is a duplicated/covered
Figma layer and is not required.

## Vector assets

### Home header and sections

| Filename | Figma size | Usage |
|---|---:|---|
| `ic_notification.xml` | 20×20 | Notification button |
| `ic_arrow_right_small.xml` | 14×14 | “Daha çox” action |
| `ic_bookmark.xml` | 16×16 | FitMarket bookmark |
| `ic_star_filled.xml` | 14×14 | Gym rating |
| `ic_location.xml` | 20×20 | Gym location |
| `ic_direction.xml` | 20×20 | Gym distance/direction |

### Bottom navigation

| Filename | Figma size | Usage |
|---|---:|---|
| `ic_nav_home.xml` | 24×24 | Əsas səhifə |
| `ic_nav_search.xml` | 24×24 | Axtarış |
| `ic_nav_qr.xml` | 28×28 | QR |
| `ic_nav_subscription.xml` | 24×24 | Abunəlik |
| `ic_nav_more.xml` | 24×24 | Daha çox |

Only Home is a functional destination in the requested task. The remaining
bottom-navigation items are visual elements unless otherwise required.

### Profile

| Filename | Figma size | Usage |
|---|---:|---|
| `ic_arrow_back.xml` | 24×24 | Back action |
| `ic_edit_avatar.xml` | 16×16 | Avatar edit badge |
| `ic_user.xml` | 18×18 | Name and surname |
| `ic_edit_field.xml` | 24×24 | Profile field edit |
| `ic_phone.xml` | 18×18 | Mobile number |
| `ic_email.xml` | 18×18 | Email |
| `ic_profile_plan.xml` | 18×18 | Current subscription |
| `ic_logout.xml` | 20×20 | Logout |
| `ic_chevron_right.xml` | 24×24 | Logout trailing action |

## Storage strategy

### Raster images

Repository location:

`assets/images/`

Application loading:

- Stable hardcoded GitHub raw URLs
- Coil `AsyncImage`
- Loading and error placeholders
- Explicit `ContentScale.Crop`

Temporary Figma URLs will only be used to download the source asset and will
never be committed into Kotlin source code.

### Vector icons

Android project location:

`app/src/main/res/drawable/`

Exact exported SVG files will be converted to Android Vector Drawable XML
where supported. Each converted icon will be visually checked against Figma.

## Inventory totals

| Asset type | Count |
|---|---:|
| Category raster images | 9 |
| FitMarket raster images | 2 |
| Gym raster images | 4 |
| Profile raster images | 1 |
| Home/section vector icons | 6 |
| Bottom-navigation vector icons | 5 |
| Profile vector icons | 9 |
| Total raster images | 16 |
| Total vector icons | 20 |
| Total application assets | 36 |

## Excluded reference assets

The following Figma elements will not be added as application assets:

- iPhone status bar time
- iPhone cellular icon
- iPhone Wi-Fi icon
- iPhone battery icon
- iPhone home indicator
- Full Home/Profile screenshots
- Hidden badge layers
- The duplicated hidden Dark profile avatar background layer