package nl.cryonic.kit;

import nl.cryonic.KitPvP;
import nl.cryonic.Main;
import nl.cryonic.kit.abilities.BattleStrength;
import nl.cryonic.utils.ColorUtil;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KitManager {

    private ArrayList<Kit> kits = new ArrayList<>();

    public KitManager() {
        loadKnight();
    }

    public void loadKit(Kit kit) {
        kit.getAbilities().forEach(ability -> {
            KitPvP.INSTANCE.getPlugin().getPluginLoader().createRegisteredListeners(ability, KitPvP.INSTANCE.getPlugin());
        });
        kits.add(kit);
    }

    public void loadKnight() {
        List<ItemStack> items = new ArrayList<>();
        ArrayList<Ability> abilities = new ArrayList<>();
        ItemStack SWORD = createItem(Material.IRON_SWORD, "&aKnight's Sword", "&aDecent sword for a fight.");
        items.add(SWORD);
        ItemStack ability = createItem(Material.BLAZE_POWDER, "&aBattle Strength", "&aGives resistance and strength for 5 seconds.");
        items.add(ability);
        abilities.add(new BattleStrength(ability));
        List<ItemStack> armor = new ArrayList<>();
        armor.add(createItem(Material.CHAINMAIL_BOOTS, "&aChain Boots"));
        armor.add(createItem(Material.CHAINMAIL_LEGGINGS, "&aChain Leggings"));
        armor.add(createItem(Material.CHAINMAIL_CHESTPLATE, "&aChain Chestplate"));
        armor.add(createItem(Material.CHAINMAIL_HELMET, "&aChain Helmet"));
        ItemStack[] convertitems = new ItemStack[items.size()];
        items.toArray(convertitems);
        ItemStack[] convertarmor = new ItemStack[armor.size()];
        armor.toArray(convertarmor);
        loadKit(new Kit(ColorUtil.translate("&aKnight"), Material.IRON_SWORD, 0, convertitems, convertarmor,abilities, ColorUtil.translate("&aSimple default kit")));

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
