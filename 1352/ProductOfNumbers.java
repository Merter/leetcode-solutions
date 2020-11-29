class ProductOfNumbers1 {
    
    private List<Integer> numbers;

    public ProductOfNumbers() {
        numbers = new ArrayList<>();
    }
    
    public void add(int num) {
        numbers.add(num);
    }
    
    public int getProduct(int k) {
        int product = 1;
        for (int i=0; i<k; i++) {
            product *= numbers.get(numbers.size()-i-1);
        }
        return product;
    }
}

class ProductOfNumbers2 {
    
    private List<Integer> products;

    public ProductOfNumbers() {
        products = new ArrayList<>();
    }
    
    public void add(int num) {
        for (int i=0; i<products.size(); i++) {
            products.set(i, products.get(i)*num);
        }
        products.add(num);
    }
    
    public int getProduct(int k) {
        return products.get(products.size()-k);
    }
}

class ProductOfNumbers3 {
    
    private List<Integer> products;
    private TreeSet<Integer> zeroPositions;

    public ProductOfNumbers() {
        products = new ArrayList<>();
        products.add(1);
        zeroPositions = new TreeSet<>();
    }
    
    public void add(int num) {
        if (num == 0) {
            zeroPositions.add(products.size());
        }
        products.add(products.get(products.size()-1) * num);
    }
    
    public int getProduct(int k) {
        int lastProduct = products.get(products.size()-1);
        if (lastProduct == 0) {
            return 0;
        }
        int prevProduct = products.get(size()-1-k);
        if (prevProduct == 0) {
            return lastProduct / products.get(products.size()-k);
        }
        if (zeroPositions.tailSet(products.size()-1-k) != null) {
            return 0;
        }
        return lastProduct / prevProduct;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
add sequence: 3 2 5 4 8
[1, 3, 6, 30, 120, 960]

add sequence: 3 2 0 5 4 8
[1, 3, 6, 0, 5, 20, 160] k==1 => 
    a = products.get(products.size()-1) if 0 return 0
    b = products.get(size()-1-k) if 0 return a/products.get(products.size()-k)
    if zeroPositionsTreeSet.tail(products.size()-1-k) != null return 0
    return a/b
zeroPositionsTreeSet{3}

add sequence: 3 2 0 5 4 8 0 1 5
[1, 3, 6, 0, 5, 20, 160, 0, 1, 5]
zeroPositionsTreeSet{3, 7}

