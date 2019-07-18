package naturix.divinerpg.capabilities;

public interface IArcana
{
    public void consume(float points);

    public void fill(float points);

    public void set(float points);
    
    public float getArcana();
    
    public void updateAllBars();            
}