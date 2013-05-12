package mobiles;

import java.util.LinkedList;

public class Party {
    
    LinkedList<PartyMember> partyMembers = new LinkedList();
    
    public Party(){
        
    }
    
    public void addPartyMember(PartyMember p){
        partyMembers.add(p);
    }

    public LinkedList<PartyMember> getParty() {
        return partyMembers;
    }
    
}
