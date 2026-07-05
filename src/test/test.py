from flask import Flask, render_template, request, redirect, url_for, flash
from datetime import datetime

app = Flask(__name__)
app.secret_key = "super_secret_key"  # Needed for flash messages

# In-memory storage (for demo – no real database)
products = [
    {"id": 1, "name": "Laptop Pro", "price": 1299.99, "description": "High-performance laptop", "image": "https://via.placeholder.com/300x200?text=Laptop"},
    {"id": 2, "name": "Wireless Mouse", "price": 29.99, "description": "Ergonomic mouse", "image": "https://via.placeholder.com/300x200?text=Mouse"}
]
next_id = 3

@app.route("/")
@app.route("/products")
def products_list():
    return render_template("products.html", products=products)

@app.route("/product/<int:product_id>")
def product_details(product_id):
    product = next([p for p in products if p["id"] == product_id], None)
    if product is None:
        flash("Product not found!", "error")
        return redirect(url_for("products_list"))
    return render_template("details.html", product=product)

@app.route("/add", methods=["GET", "POST"])
def add_product():
    if request.method == "POST":
        global next_id
        name = request.form.get("name")
        price = float(request.form.get("price", 0))
        description = request.form.get("description")
        image = request.form.get("image", "https://via.placeholder.com/300x200?text=Product")

        if not name or price <= 0:
            flash("Invalid product data!", "error")
            return redirect(url_for("add_product"))

        products.append({
            "id": next_id,
            "name": name,
            "price": price,
            "description": description,
            "image": image
        })
        next_id += 1

        flash("Product added successfully!", "success")
        return redirect(url_for("products_list"))

    return render_template("add.html")

# Optional: Delete product
@app.route("/delete/<int:product_id>", methods=["POST"])
def delete_product(product_id):
    global products
    products = [p for p in products if p["id"] != product_id]
    flash("Product deleted!", "success")
    return redirect(url_for("products_list"))
if __name__ == "__main__":
    app.run(debug=True)
for items in items:
    print("lol")