package Object;

public class ListeTabluee implements Liste{
    public static final int MAX = 4;
    public Object listeTabulee[];
    public int occupation;


    public ListeTabluee(){
        listeTabulee = new Object[MAX];
        this.occupation = 0;
    }

    @Override
    public void vider(){
        while (this.occupation > 0){
            this.listeTabulee[this.occupation - 1] = null;
            this.occupation--;
        }
    }

    @Override
    public boolean estVide(){
        return this.occupation == 0;
    }

    @Override
    public Iterateur iterateur(){
        return new IterateurListeTabulee(this);
    }
}
