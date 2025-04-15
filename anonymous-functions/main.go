package main

import "fmt"

func getOperation(operator string) func(a, b int) int {
	switch operator {
	case "+":
		return func(a, b int) int {
			return a + b
		}
	case "-":
		return func(a, b int) int {
			return a - b
		}
	case "*":
		return func(a, b int) int {
			return a * b
		}
	default:
		return func(a, b int) int {
			return 0
		}
	}
}

func main() {
	a := 5
	b := 6

	addValues := getOperation("+")
	fmt.Println(addValues(a, b))
	multiplyValues := getOperation("*")
	fmt.Println(multiplyValues(a, b))
	undefinedOperation := getOperation("")
	fmt.Println(undefinedOperation(a, b))
	fmt.Println(execute(func(a, b int) int {
		return a / b
	}, b, a))

}

func execute(operation func(a, b int) int, a, b int) int {
	return operation(a, b)
}
