package skill;

import character.Character;

import java.util.HashSet;
import java.util.Iterator;

public class SkillSet {

    private Character character;
    private HashSet<Skill> skillHashSet;

    public SkillSet(Character character) {
        this.character = character;
        this.skillHashSet = new HashSet<Skill>();
    }

    public void addSkill(Skill skill) {
        skillHashSet.add(skill);
    }

    public Skill getSkill(String s) {
        Iterator<Skill> iterator = skillHashSet.iterator();
        while (iterator.hasNext()) {
            Skill skill = iterator.next();
            if (skill.toString() == s) {
                return skill;
            }
        }
        return null;
    }

}
