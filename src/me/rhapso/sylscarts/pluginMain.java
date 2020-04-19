package me.rhapso.sylscarts;

import org.bukkit.plugin.java.JavaPlugin;

public class pluginMain extends JavaPlugin {

    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(new cartListener(), this);
    }

}
