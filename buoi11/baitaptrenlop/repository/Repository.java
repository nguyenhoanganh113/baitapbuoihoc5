package buoi11.baitaptrenlop.repository;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.*;

@FieldDefaults(level = AccessLevel.PROTECTED)
public class Repository<T>{

    Map<String, T> storage = new HashMap<>();

    //Thêm phần tử
    public void add(String id, T item){
        storage.put(id, item);
    }

    //Xóa
    public void remove(String id){
        storage.remove(id);
    }

    //Tìm theo ID
    public Optional<T> findById(String id){
        return Optional.ofNullable(storage.get(id));
    }

    //Lấy toàn bộ
    public List<T> findAll(){
        return new ArrayList<>(storage.values());
    }

    //Kiểm tra tồn tại
    public boolean exists(String id){
        return storage.containsKey(id);
    }

}
