package jdbc;

import charactor.SimpleHero;

import java.util.List;

public interface DAO {
    public void add(SimpleHero hero);

    public void delete(int id);

    public void update(SimpleHero hero);

    public SimpleHero get(int id);

    public List<SimpleHero> list();

    public List<SimpleHero> list(int start, int count);
}
