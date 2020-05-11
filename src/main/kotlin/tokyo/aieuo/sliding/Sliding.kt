package tokyo.aieuo.sliding

import cn.nukkit.Player
import cn.nukkit.event.EventHandler
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerToggleSneakEvent
import cn.nukkit.event.player.PlayerToggleSprintEvent
import cn.nukkit.math.Vector3
import cn.nukkit.plugin.PluginBase
import kotlin.math.cos
import kotlin.math.sin

class Sliding: PluginBase(), Listener {

    private val sprintTicks = mutableMapOf<Player, Int>()

    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
    }

    @EventHandler
    fun onSneak(event: PlayerToggleSneakEvent) {
        val player = event.player
        if (event.isSneaking && server.tick - (sprintTicks[player] ?: 0) == 0) {
            val deg = player.yaw / 180 * Math.PI
            player.motion = Vector3((-sin(deg)) * 2.5, -0.5, (cos(deg)) * 2.5)
        }
    }

    @EventHandler
    fun onSprint(event: PlayerToggleSprintEvent) {
        sprintTicks[event.player] = server.tick
    }
}