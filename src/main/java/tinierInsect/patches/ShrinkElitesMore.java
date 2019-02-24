package tinierInsect.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;


@SpirePatch(
        clz = AbstractCreature.class,
        method = "loadAnimation"
)

public class ShrinkElitesMore {
    public ShrinkElitesMore() {
    }

    @SpireInsertPatch(rloc = 9)
    public static void Insert(AbstractCreature __instance, float scale) {
        if (CardCrawlGame.dungeon != null && AbstractDungeon.player != null) {
            if (AbstractDungeon.player.hasRelic("PreservedInsect") && !__instance.isPlayer && AbstractDungeon.getCurrRoom().eliteTrigger) {
                scale += 0.7F;
            }

        }
    }
}