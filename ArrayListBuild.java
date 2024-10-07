public class ArrayListBuild<T> {
    private T[] elements;   // Mảng chứa các phần tử
    private int size = 0;   // Số lượng phần tử hiện có trong danh sách

    // Constructor khởi tạo mảng với kích thước mặc định
    public ArrayListBuild() {
        elements = (T[]) new Object[10]; // Khởi tạo mảng với kiểu Object và ép kiểu
    }
    // Phương thức thêm phần tử vào danh sách
    public void add(T element) {
        if (size == elements.length) { // Nếu mảng đầy, tăng kích thước
            T[] newElements = (T[]) new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        elements[size++] = element;
    }
    public boolean remove(T element) {
        int index = -1;
        // Tìm phần tử cần xóa
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                index = i;
                break;
            }
        }
        // Nếu không tìm thấy phần tử cần xóa
        if (index == -1) {
            return false;  // Phần tử không có trong danh sách
        }
        // Di chuyển các phần tử phía sau phần tử cần xóa
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];  // Di chuyển phần tử tiếp theo lên
        }
        // Xóa phần tử cuối cùng (vì nó đã được di chuyển lên)
        elements[size - 1] = null;
        // Giảm kích thước danh sách
        size--;
        return true;  // Đã xóa thành công
    }
    public int size() {
        return size;
    }
    // Phương thức lấy phần tử tại một chỉ số
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }
    public void set(int index, T element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        elements[index] = element;
    }
    // Tự xây dựng phương thức "foreach" bằng cách lặp qua các phần tử
    public void forEach(CustomAction<T> action) {
        for (int i = 0; i < size; i++) {
            action.execute(elements[i]); // Áp dụng hành động cho từng phần tử
        }
    }
    // Giao diện CustomAction để định nghĩa hành động trên mỗi phần tử
    public interface CustomAction<T> {
        void execute(T element); // Phương thức thực hiện hành động trên mỗi phần tử
    }
}
