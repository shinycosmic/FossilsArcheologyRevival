package com.fossil.fossil.entity.prehistoric.base;

import com.fossil.fossil.item.DNAItem;
import com.fossil.fossil.item.MammalEmbryoItem;
import com.fossil.fossil.item.ModItems;
import com.fossil.fossil.item.ModTabs;
import com.fossil.fossil.util.Diet;
import com.fossil.fossil.util.FoodMappings;
import com.fossil.fossil.util.TimePeriod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;

public enum PrehistoricEntityType {
    CHICKEN(EntityType.CHICKEN, PrehistoricMobType.CHICKEN, TimePeriod.CURRENT, Diet.HERBIVORE),
    COW(EntityType.COW, PrehistoricMobType.VANILLA, TimePeriod.CURRENT, Diet.HERBIVORE),
    DONKEY(EntityType.DONKEY, PrehistoricMobType.VANILLA, TimePeriod.CURRENT, Diet.HERBIVORE),
    HORSE(EntityType.HORSE, PrehistoricMobType.VANILLA, TimePeriod.CURRENT, Diet.HERBIVORE),
    LLAMA(EntityType.LLAMA, PrehistoricMobType.VANILLA, TimePeriod.CURRENT, Diet.HERBIVORE),
    PARROT(EntityType.PARROT, PrehistoricMobType.CHICKEN, TimePeriod.CURRENT, Diet.HERBIVORE),
    PIG(EntityType.PIG, PrehistoricMobType.VANILLA, TimePeriod.CURRENT, Diet.OMNIVORE),
    POLARBEAR(EntityType.POLAR_BEAR, PrehistoricMobType.VANILLA, TimePeriod.CURRENT, Diet.HERBIVORE),
    RABBIT(EntityType.RABBIT, PrehistoricMobType.VANILLA, TimePeriod.CURRENT, Diet.HERBIVORE),
    SHEEP(EntityType.SHEEP, PrehistoricMobType.VANILLA, TimePeriod.CURRENT, Diet.HERBIVORE),
    ALLIGATOR_GAR(PrehistoricMobType.FISH, TimePeriod.MESOZOIC, Diet.NONE),
    ALLOSAURUS(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.CARNIVORE),
    ANKYLOSAURUS(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE),
    ARTHROPLEURA(PrehistoricMobType.DINOSAUR_AQUATIC, TimePeriod.PALEOZOIC, Diet.HERBIVORE),
    BRACHIOSAURUS(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE),
    CERATOSAURUS(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.CARNIVORE),
    CITIPATI(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.OMNIVORE),
    COELACANTH(PrehistoricMobType.FISH, TimePeriod.MESOZOIC, Diet.NONE),
    COMPSOGNATHUS(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.CARNIVORE),
    CONFUCIUSORNIS(PrehistoricMobType.BIRD, TimePeriod.MESOZOIC, Diet.HERBIVORE),
    CRASSIGYRINUS(PrehistoricMobType.DINOSAUR_AQUATIC, TimePeriod.PALEOZOIC, Diet.PISCIVORE),
    DEINONYCHUS(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.CARNIVORE_EGG),
    DILOPHOSAURUS(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.CARNIVORE),
    DIPLOCAULUS(PrehistoricMobType.DINOSAUR_AQUATIC, TimePeriod.PALEOZOIC, Diet.PISCIVORE),
    DIPLODOCUS(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE),
    DRYOSAURUS(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE),
    DODO(PrehistoricMobType.BIRD, TimePeriod.CENOZOIC, Diet.HERBIVORE),
    EDAPHOSAURUS(PrehistoricMobType.DINOSAUR, TimePeriod.PALEOZOIC, Diet.HERBIVORE),
    ELASMOTHERIUM(PrehistoricMobType.MAMMAL, TimePeriod.CENOZOIC, Diet.HERBIVORE),
    GALLIMIMUS(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.OMNIVORE),
    GASTORNIS(PrehistoricMobType.BIRD, TimePeriod.CENOZOIC, Diet.HERBIVORE),
    HENODUS(PrehistoricMobType.DINOSAUR_AQUATIC, TimePeriod.MESOZOIC, Diet.HERBIVORE),
    ICHTYOSAURUS(PrehistoricMobType.DINOSAUR_AQUATIC, TimePeriod.MESOZOIC, Diet.PISCIVORE),
    KELENKEN(PrehistoricMobType.BIRD, TimePeriod.CENOZOIC, Diet.CARNIVORE),
    LIOPLEURODON(PrehistoricMobType.DINOSAUR_AQUATIC, TimePeriod.MESOZOIC, Diet.PISCI_CARNIVORE),
    MAMMOTH(PrehistoricMobType.MAMMAL, TimePeriod.CENOZOIC, Diet.HERBIVORE),
    MEGALANIA(PrehistoricMobType.DINOSAUR, TimePeriod.CENOZOIC, Diet.CARNIVORE_EGG),
    MEGALOCEROS(PrehistoricMobType.MAMMAL, TimePeriod.CENOZOIC, Diet.HERBIVORE),
    MEGALODON(PrehistoricMobType.DINOSAUR_AQUATIC, TimePeriod.CENOZOIC, Diet.PISCI_CARNIVORE),
    MEGALOGRAPTUS(PrehistoricMobType.DINOSAUR_AQUATIC, TimePeriod.PALEOZOIC, Diet.PISCIVORE),
    MEGANEURA(PrehistoricMobType.DINOSAUR_AQUATIC, TimePeriod.PALEOZOIC, Diet.PISCI_CARNIVORE),
    MOSASAURUS(PrehistoricMobType.DINOSAUR_AQUATIC, TimePeriod.MESOZOIC, Diet.PISCI_CARNIVORE),
    NAUTILUS(PrehistoricMobType.FISH, TimePeriod.MESOZOIC, Diet.NONE),
    ORNITHOLESTES(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.CARNIVORE_EGG),
    PACHYCEPHALOSAURUS(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE),
    PARASAUROLOPHUS(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE),
    PHORUSRHACOS(PrehistoricMobType.BIRD, TimePeriod.CENOZOIC, Diet.CARNIVORE),
    PLATYBELODON(PrehistoricMobType.MAMMAL, TimePeriod.CENOZOIC, Diet.HERBIVORE),
    PLESIOSAURUS(PrehistoricMobType.DINOSAUR_AQUATIC, TimePeriod.MESOZOIC, Diet.PISCIVORE),
    PTERANODON(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.PISCIVORE),
    PTEROSAUR(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.PISCIVORE),
    QUAGGA(PrehistoricMobType.MAMMAL, TimePeriod.CENOZOIC, Diet.HERBIVORE),
    SARCOSUCHUS(PrehistoricMobType.DINOSAUR_AQUATIC, TimePeriod.MESOZOIC, Diet.PISCI_CARNIVORE),
    SMILODON(PrehistoricMobType.MAMMAL, TimePeriod.CENOZOIC, Diet.CARNIVORE),
    SPINOSAURUS(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.PISCI_CARNIVORE),
    STEGOSAURUS(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE),
    STURGEON(PrehistoricMobType.FISH, TimePeriod.MESOZOIC, Diet.NONE),
    THERIZINOSAURUS(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE),
    TIKTAALIK(PrehistoricMobType.DINOSAUR_AQUATIC, TimePeriod.PALEOZOIC, Diet.PISCI_CARNIVORE),
    TITANIS(PrehistoricMobType.BIRD, TimePeriod.CENOZOIC, Diet.CARNIVORE),
    TRICERATOPS(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE, true),
    TYRANNOSAURUS(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.CARNIVORE),
    VELOCIRAPTOR(PrehistoricMobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.CARNIVORE_EGG);
    public final EntityType<? extends Entity> entity;
    public final PrehistoricMobType mobType;
    public final TimePeriod timePeriod;
    public final Diet diet;
    public final String resourceName;
    private final boolean hasBoneItems;
    public Item dnaItem;
    public Item eggItem;
    public Item embryoItem;
    public Item birdEggItem;
    public Item cultivatedBirdEggItem;
    public Item legBoneItem;
    public Item armBoneItem;
    public Item footBoneItem;
    public Item skullBoneItem;
    public Item ribcageBoneItem;
    public Item vertebraeBoneItem;
    public Item uniqueBoneItem;
    public Item foodItem;
    public Item cookedFoodItem;
    public Item fishItem;

    PrehistoricEntityType(PrehistoricMobType mobType, TimePeriod timePeriod, Diet diet) {
        this.entity = null;
        this.mobType = mobType;
        this.timePeriod = timePeriod;
        this.diet = diet;
        this.resourceName = this.name().toLowerCase(Locale.ENGLISH);
        this.hasBoneItems = false;
    }

    PrehistoricEntityType(PrehistoricMobType mobType, TimePeriod timePeriod, Diet diet, boolean hasBoneItems) {
        this.entity = null;
        this.mobType = mobType;
        this.timePeriod = timePeriod;
        this.diet = diet;
        this.resourceName = this.name().toLowerCase(Locale.ENGLISH);
        this.hasBoneItems = hasBoneItems;
    }

    PrehistoricEntityType(EntityType<? extends Entity> entity, PrehistoricMobType mobType, TimePeriod timePeriod, Diet diet) {
        this.entity = entity;
        this.mobType = mobType;
        this.timePeriod = timePeriod;
        this.diet = diet;
        this.resourceName = this.name().toLowerCase(Locale.ENGLISH);
        this.hasBoneItems = false;
    }

    public static void register() {
        for (PrehistoricEntityType type : PrehistoricEntityType.values()) {
            ModItems.ITEMS.register(type.resourceName + "_dna", () -> new DNAItem(type)).listen(item -> type.dnaItem = item);
            if (type.hasBoneItems) {
                registerItem("bone_leg", type, Item::new, item -> type.legBoneItem = item);
                registerItem("bone_arm", type, Item::new, item -> type.armBoneItem = item);
                registerItem("bone_foot", type, Item::new, item -> type.footBoneItem = item);
                registerItem("bone_skull", type, Item::new, item -> type.skullBoneItem = item);
                registerItem("bone_ribcage", type, Item::new, item -> type.ribcageBoneItem = item);
                registerItem("bone_vertebrae", type, Item::new, item -> type.vertebraeBoneItem = item);
                registerItem("bone_unique_item", type, Item::new, item -> type.uniqueBoneItem = item);
            }
            if (type.mobType == PrehistoricMobType.FISH) {
                FoodMappings.addFish(type.entity, 100);//TODO: Define value somewhere. Also should all dinos be added here?
                registerItem("fish", type, Item::new, item -> type.fishItem = item);
                registerItem("egg", type, Item::new, item -> type.eggItem = item);
            } else if (type.mobType == PrehistoricMobType.DINOSAUR) {
                FoodMappings.addMeat(type.entity, 100);
                registerItem("egg_item", type, Item::new, item -> type.eggItem = item);
            } else if (type.mobType == PrehistoricMobType.MAMMAL || type.mobType == PrehistoricMobType.VANILLA) {
                registerItem("syringe", type, properties -> new MammalEmbryoItem(type), item -> type.embryoItem = item);
            } else if (type.mobType == PrehistoricMobType.BIRD || type.mobType == PrehistoricMobType.CHICKEN) {
                FoodMappings.addMeat(type.entity, 100);
                if (type.mobType == PrehistoricMobType.BIRD) {
                    registerItem("egg", type, Item::new, item -> type.birdEggItem = item);
                }
                registerItem("egg_cultivated", type, Item::new, item -> type.cultivatedBirdEggItem = item);
            }
            if (type.timePeriod != TimePeriod.CURRENT) {
                if (type.mobType != PrehistoricMobType.FISH) {
                    ModItems.ITEMS.register("meat_" + type.resourceName, () -> new Item(new Item.Properties().tab(ModTabs.FAITEMTAB)
                                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).build())))
                            .listen(item -> type.foodItem = item);
                }
                if (type != NAUTILUS) {
                    ModItems.ITEMS.register("cooked_" + type.resourceName, () -> new Item(new Item.Properties().tab(ModTabs.FAITEMTAB)
                                    .food(new FoodProperties.Builder().nutrition(8).saturationMod(0.8f).build())))
                            .listen(item -> type.cookedFoodItem = item);
                }
            }
        }
    }

    private static void registerItem(String name, PrehistoricEntityType type, Function<Item.Properties, Item> item, Consumer<Item> listener) {
        ModItems.ITEMS.register(name + "_" + type.resourceName, () -> item.apply(new Item.Properties().tab(ModTabs.FAITEMTAB))).listen(listener);
    }

    public @Nullable Item getDNAResult() {
        if (eggItem != null) {
            return eggItem;
        } else if (embryoItem != null) {
            return embryoItem;
        } else if (cultivatedBirdEggItem != null) {
            return cultivatedBirdEggItem;
        }
        return null;
    }

    public static List<PrehistoricEntityType> getTimePeriodList(TimePeriod... periods) {
        List<PrehistoricEntityType> list = new ArrayList<>();
        for (PrehistoricEntityType entity : PrehistoricEntityType.values()) {
            for (TimePeriod period : periods) {
                if (entity.timePeriod == period) {
                    list.add(entity);
                }
            }
        }
        return list;
    }

    private static List<PrehistoricEntityType> boneCache;
    private static List<PrehistoricEntityType> dnaCache;

    public static List<PrehistoricEntityType> entitiesWithBones() {
        if (boneCache == null) {
            boneCache = Arrays.stream(values()).filter(type -> type.hasBoneItems).toList();
        }
        return boneCache;
    }

    public static List<PrehistoricEntityType> entitiesWithDNAResult() {
        if (dnaCache == null) {
            dnaCache = Arrays.stream(values()).filter(
                    type -> type.eggItem != null || type.embryoItem != null || type.cultivatedBirdEggItem != null).toList();
        }
        return dnaCache;
    }

    public static boolean isMammal(Mob mob) {
        //TODO: Maybe could be done with tags?
        String className = "";
        try {
            className = mob.getClass().getSimpleName();
        } catch (Exception e) {
            System.out.println(e);
        }
        return !className.isEmpty() && (mob instanceof Cow || mob instanceof Sheep || mob instanceof Pig || mob instanceof Chicken
                || mob instanceof Rabbit || mob instanceof AbstractHorse || mob instanceof Prehistoric prehistoric &&
                prehistoric.type().mobType == PrehistoricMobType.MAMMAL || mob instanceof PolarBear || mob instanceof Wolf || mob instanceof Ocelot
                || mob instanceof Bat || className.contains("Cow") || className.contains("Sheep") || className.contains("Pig")
                || className.contains("Rabbit") || className.contains("Goat") || className.contains("Ferret") || className.contains("Hedgehog")
                || className.contains("Sow") || className.contains("Hog"));
    }
}
