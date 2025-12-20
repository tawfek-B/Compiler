@route("/home")
def home(a, b, c):
    x = 10
    y = 20.5
    z = x + y * 2 - 5 / 1

    nums = [1, 2, 3, 4]
    data = {key: 1, value: 2}

    if x > 5:
        result = "x is greater"
    elif x == 5:
        result = "x equals five"
    else:
        result = "x is smaller"

    for i in range(0, 3):
        temp = i * 2

    for item in nums:
        value = item + 1

    return result


def math_ops(n):
    a = n % 2
    b = (n + 3) * 4
    c = n == 10
    d = n != 5
    e = n >= 1
    f = n <= 100
    return a


x = 10


def call_examples():
    x = home(1, 2, 3)
    y = math_ops(10)
    z = print("Hello, World")
    return x


def while_examples(limit):
    i = 0
    total = 0

    while i < limit:
        total = total + i
        i = i + 1

    return total


def nested_while():
    i = 0
    j = 0

    while i < 3:
        j = 0
        while j < 2:
            temp = i * j
            j = j + 1
        i = i + 1

    return temp


def try_examples(a, b):
    try:
        result = a / b
    except ZeroDivisionError:
        result = 0
    finally:
        print("Division attempted")

    return result


def multiple_except(n):
    try:
        value = int(n)
        result = 10 / value
    except ValueError:
        result = -1
    except ZeroDivisionError:
        result = 0
    finally:
        status = "done"

    return result


def try_without_except(x):
    try:
        y = x + 1
    finally:
        print("Finally executed")

    return y


try:
    a = 10
    b = 0
    c = a / b
except ZeroDivisionError:
    c = -1
finally:
    message = "End of program"


# Single-line comment

"""
This is a multiline comment.
It should be ignored by the lexer.
"""

value = 42
text = "Done"
