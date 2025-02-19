package com.fossil.fossil.world.biome;

import com.fossil.fossil.Fossil;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

/**
 * Stores the resource keys for the custom biomes
 */
public class ModBiomes {
    public static final ResourceKey<Biome> VOLCANO_KEY = resource("volcano");

    private static ResourceKey<Biome> resource(String name) {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Fossil.MOD_ID, name));
    }
}
