package naturix.divinerpg.capabilities;

public class Arcana implements IArcana
{
    private float arcana = 200.0F; 

    @Override
    public void consume(float points)
    {
        this.arcana -= points;

        if (this.arcana < 0.0F) this.arcana = 0.0F;
    }

    @Override
    public void fill(float points)
    {
        this.arcana += points;
    }

    @Override
    public void set(float points)
    {
        this.arcana = points;
    }

    @Override
    public float getArcana()
    {
        return this.arcana;
    }

}