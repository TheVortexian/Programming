#include "x64/src/graphics/window.h"

int main() {
	
	using namespace elcEngine;
	using namespace graphics;

	Window window("Test name", 800, 600);
	glClearColor(0.3f, 0.1f, 0.6f, 0.5f);

	while (!window.closed())
	{
		glClear(GL_COLOR_BUFFER_BIT);
		window.update();
	}
		
}