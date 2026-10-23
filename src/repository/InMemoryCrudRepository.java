package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryCrudRepository<T,ID> implements CrudRepository<T,ID> {
    private final List<T> enitities = new ArrayList<>();
    @Override
    public void save(T enitity){
        enitities.add(enitity);
        System.out.println("In-Memory Репозиторий: Объект успешно сохранен.");
    }
    @Override
    public Optional<T>findById(ID id){
        if(enitities.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(enitities.get(0));
    }
    @Override
    public List<T> findAll(){
        return new ArrayList<>(enitities);
    }
    @Override
    public void deleteById(ID id){
        if(!enitities.isEmpty()){
            enitities.remove(0);
            System.out.println("In-Memory Репозиторий: Объект удален.");
        }
    }
}
