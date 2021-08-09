package nl.cryonic.kit;

import lombok.Getter;
import nl.cryonic.KitPvP;
import nl.cryonic.kit.abilities.archer.MachineGun;
import nl.cryonic.kit.abilities.enderman.Recall;
import nl.cryonic.kit.abilities.ninja.Dash;
import nl.cryonic.kit.abilities.knight.BattleStrength;
import nl.cryonic.kit.abilities.thumper.KnockOut;
import nl.cryonic.kit.abilities.vampire.Vampire;
import nl.cryonic.utils.ColorUtil;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KitManager {

    @Getter
    private final ArrayList<Kit> kits = new ArrayList<>();

    public KitManager() {
        loadKnight();
        loadArcher();
        loadThumper();
        loadVampire();
        loadNinja();
        loadEnderman();
    }

    public void loadKit(Kit kit) {
        kits.add(kit);
    }

    public void loadKnight() {
        List<ItemStack> items = new ArrayList<>();
        ItemStack SWORD = createItem(Material.STONE_SWORD, "&aKnight's Sword", "&aDecent sword for a fight.");
        items.add(SWORD);
        ItemStack ability = createItem(Material.BLAZE_POWDER, "&aBattle Strength", "&aGives THE POWER OF THE STEWIN for 5 seconds.");
        items.add(ability);
        KitPvP.INSTANCE.getPlugin().getServer().getPluginManager().registerEvents(new BattleStrength(ability), KitPvP.INSTANCE.getPlugin());
        List<ItemStack> armor = new ArrayList<>();
        armor.add(createItem(Material.CHAINMAIL_BOOTS, "&aChain Boots"));
        armor.add(createItem(Material.CHAINMAIL_LEGGINGS, "&aChain Leggings"));
        armor.add(createItem(Material.CHAINMAIL_CHESTPLATE, "&aChain Chestplate"));
        armor.add(createItem(Material.CHAINMAIL_HELMET, "&aChain Helmet"));
        ItemStack[] convertitems = new ItemStack[items.size()];
        items.toArray(convertitems);
        ItemStack[] convertarmor = new ItemStack[armor.size()];
        armor.toArray(convertarmor);
        loadKit(new Kit(ColorUtil.translate("&aKnight"), Material.IRON_SWORD, 0, convertitems, convertarmor, ColorUtil.translate("&aSimple default kit")));

    }

    public void loadArcher() {
        List<ItemStack> items = new ArrayList<>();
        ItemStack sword = createItem(Material.STONE_SWORD, "&6Archer Sword", "&aEpik weapon for slicing foes.");
        ItemStack bow = createInfiniteBow(Material.BOW, "&6Archer Bow", "&1Bow");
        ItemStack arrow = createItem(Material.ARROW, "&aMachine Gun", "&aRight click to fire a machine gun");
        items.add(sword);
        items.add(bow);
        items.add(arrow);

        KitPvP.INSTANCE.getPlugin().getServer().getPluginManager().registerEvents(new MachineGun(arrow), KitPvP.INSTANCE.getPlugin());

        List<ItemStack> armor = new ArrayList<>();
        armor.add(createItem(Material.CHAINMAIL_BOOTS, "&aChain Boots"));
        armor.add(createItem(Material.CHAINMAIL_LEGGINGS, "&aChain Leggings"));
        armor.add(createItem(Material.CHAINMAIL_CHESTPLATE, "&aChain Chestplate"));
        armor.add(createItem(Material.CHAINMAIL_HELMET, "&aChain Helmet"));

        ItemStack[] convertitems = new ItemStack[items.size()];
        items.toArray(convertitems);
        ItemStack[] convertarmor = new ItemStack[armor.size()];
        armor.toArray(convertarmor);
        kits.add(new Kit(ColorUtil.translate("&aArcher"), Material.BOW, 0, convertitems, convertarmor, ColorUtil.translate("&aBecome a archer")));
    }

    public void loadThumper() {
        List<ItemStack> items = new ArrayList<>();

        ItemStack sword = createItem(Material.GOLDEN_AXE, "&6Thumper Axe", "&aShift left click and hit an entity to knock out");
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
        items.add(sword);
        KitPvP.INSTANCE.getPlugin().getServer().getPluginManager().registerEvents(new KnockOut(sword), KitPvP.INSTANCE.getPlugin());

        List<ItemStack> armor = new ArrayList<>();
        armor.add(createItem(Material.GOLDEN_BOOTS, "&aGold Boots"));
        armor.add(createItem(Material.GOLDEN_LEGGINGS, "&aGold Leggings"));
        armor.add(createItem(Material.GOLDEN_CHESTPLATE, "&aGold Chestplate"));
        armor.add(createItem(Material.GOLDEN_HELMET, "&aGold Helmet"));

        ItemStack[] convertitems = new ItemStack[items.size()];
        items.toArray(convertitems);
        ItemStack[] convertarmor = new ItemStack[armor.size()];
        armor.toArray(convertarmor);
        kits.add(new Kit(ColorUtil.translate("&6Thumper"), Material.GOLDEN_AXE, 10, convertitems, convertarmor, ColorUtil.translate("&6Knock people out")));

    }

    public void loadVampire() {
        List<ItemStack> items = new ArrayList<>();

        ItemStack sword = createItem(Material.STONE_SWORD, "&cVampire Sword", "Has a chance to heal you when attacking");
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
        items.add(sword);
        KitPvP.INSTANCE.getPlugin().getServer().getPluginManager().registerEvents(new Vampire(sword), KitPvP.INSTANCE.getPlugin());

        List<ItemStack> armor = new ArrayList<>();
        armor.add(createItem(Material.CHAINMAIL_BOOTS, "&aChain Boots"));
        armor.add(createItem(Material.CHAINMAIL_LEGGINGS, "&aChain Leggings"));
        armor.add(createItem(Material.CHAINMAIL_CHESTPLATE, "&aChain Chestplate"));
        armor.add(createItem(Material.CHAINMAIL_HELMET, "&aChain Helmet"));

        ItemStack[] convertitems = new ItemStack[items.size()];
        items.toArray(convertitems);
        ItemStack[] convertarmor = new ItemStack[armor.size()];
        armor.toArray(convertarmor);
        kits.add(new Kit(ColorUtil.translate("&cVampire"), Material.GHAST_TEAR, 15, convertitems, convertarmor, ColorUtil.translate("&cHas a chance to heal you when attacking")));
    }

    public void loadNinja() {
        List<ItemStack> items = new ArrayList<>();

        ItemStack sword = createItem(Material.STONE_SWORD, "&aNinja Sword");
        ItemStack ability = createItem(Material.NETHER_STAR, "&bDash", "&aReceive a dash!");

        items.add(sword);
        items.add(ability);
        KitPvP.INSTANCE.getPlugin().getServer().getPluginManager().registerEvents(new Dash(ability), KitPvP.INSTANCE.getPlugin());

        List<ItemStack> armor = new ArrayList<>();
        armor.add(createItem(Material.CHAINMAIL_BOOTS, "&aChain Boots"));
        armor.add(createItem(Material.CHAINMAIL_LEGGINGS, "&aChain Leggings"));
        armor.add(createItem(Material.CHAINMAIL_CHESTPLATE, "&aChain Chestplate"));
        armor.add(createItem(Material.CHAINMAIL_HELMET, "&aChain Helmet"));

        ItemStack[] convertitems = new ItemStack[items.size()];
        items.toArray(convertitems);
        ItemStack[] convertarmor = new ItemStack[armor.size()];
        armor.toArray(convertarmor);

        kits.add(new Kit(ColorUtil.translate("&aNinja"), Material.NETHER_STAR, 20, convertitems, convertarmor, ColorUtil.translate("&aBe very silent and fast")));
    }

    public void loadEnderman() {
        List<ItemStack> items = new ArrayList<>();

        ItemStack sword = createItem(Material.IRON_AXE, "&aEnderman Sword");
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
        ItemStack ability = createItem(Material.CLOCK, "&dRecall", "&dTeleport to the last location you were");

        items.add(sword);
        items.add(ability);
        KitPvP.INSTANCE.getPlugin().getServer().getPluginManager().registerEvents(new Recall(ability), KitPvP.INSTANCE.getPlugin());

        List<ItemStack> armor = new ArrayList<>();
        armor.add(createItem(Material.CHAINMAIL_BOOTS, "&aChain Boots"));
        armor.add(createItem(Material.CHAINMAIL_LEGGINGS, "&aChain Leggings"));
        armor.add(createItem(Material.CHAINMAIL_CHESTPLATE, "&aChain Chestplate"));
        armor.add(createItem(Material.CHAINMAIL_HELMET, "&aChain Helmet"));

        ItemStack[] convertitems = new ItemStack[items.size()];
        items.toArray(convertitems);
        ItemStack[] convertarmor = new ItemStack[armor.size()];
        armor.toArray(convertarmor);

        kits.add(new Kit(ColorUtil.translate("&dEnderman"), Material.ENDER_PEARL, 25, convertitems, convertarmor, ColorUtil.translate("&dTeleport around places")));
    }



    protected ItemStack createItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        assert meta != null;
        meta.setDisplayName(ColorUtil.translate(name));

        // Set the lore of the item
        meta.setUnbreakable(true);
        meta.setLore(ColorUtil.translate(Arrays.asList(lore)));

        item.setItemMeta(meta);

        return item;
    }

    protected ItemStack createInfiniteBow(final Material material, final String name, String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();
        // Set the name of the item
        assert meta != null;
        meta.setDisplayName(ColorUtil.translate(name));
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        // Set the lore of the item
        meta.setUnbreakable(true);
        meta.setLore(ColorUtil.translate(Arrays.asList(lore)));

        item.setItemMeta(meta);

        return item;
    }


}
