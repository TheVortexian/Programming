#include "GLFW/glfw3.h"
#include <stdio.h>

void error_callback(int error, const char* description)
{
	fprintf(stderr, "Error: %s\n", description);
}

static void key_callback(GLFWwindow* window, int key, int scancode, int action, int mods)
{
	if (key == GLFW_KEY_ESCAPE && action == GLFW_PRESS)
		glfwSetWindowShouldClose(window, GLFW_TRUE);
}

int main() {

	glfwSetErrorCallback(error_callback); // tell glfw to use our function for errors

	if (!glfwInit())
		glfwTerminate();

	GLFWwindow* window = glfwCreateWindow(1280, 720, "Window", nullptr, nullptr);
	if (!window) {
		printf("error creating window");
		return -1;
	}
	glfwMakeContextCurrent(window);
	glfwSetKeyCallback(window, key_callback);
	glfwSwapInterval(1);
	while (!glfwWindowShouldClose(window)) {
		// loop lol
		glfwSwapBuffers(window);
		glfwPollEvents(); // ABSOLUTELY NEEDED - TELLS OPERATING SYSTEM THIS PROGRAM ISNT HANGING AND IS JUST WAITING AROUND
	}
	glfwDestroyWindow(window);
	glfwTerminate();

	return 0;
}