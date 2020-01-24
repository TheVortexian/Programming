#include "FullRenderer.h";
#include <stdio.h>
// constructor
FullRenderer::FullRenderer(char* name, int w, int h, SDL_WindowFlags wF, SDL_RendererFlags rF, int r, int g, int b, int a) {
	if (SDL_Init(SDL_INIT_EVERYTHING) < 0) {
		printf("Error initializing SDL.\n");
		return;
	}
	IMG_Init(IMG_INIT_JPG); IMG_Init(IMG_INIT_PNG); IMG_Init(IMG_INIT_TIF);
	// create window and renderer with SDL
	FullRenderer::myWindow = SDL_CreateWindow(name, SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, w, h, wF);
	FullRenderer::myRenderer = SDL_CreateRenderer(FullRenderer::getWindow(), -1, rF);
	// check if either window or renderer weren't correctly init'd
	if (FullRenderer::getWindow() == NULL) { printf("Error creating window. "); }
	if (FullRenderer::getRenderer() == NULL) { printf("Error creating renderer. "); }
	FullRenderer::setBackgroundColor(r, g, b, a); // set background color of the window
}

// loads an image
void FullRenderer::loadImage(char* name, int x, int y, double scale) {
	int w, h;
	FullRenderer::image = IMG_LoadTexture(FullRenderer::getRenderer(), name);
	SDL_QueryTexture(FullRenderer::image, NULL, NULL, &w, &h);
	SDL_Rect rect;
	rect.x = x; rect.y = y; rect.w = (int)(w * scale); rect.h = (int)(h * scale);
	if (FullRenderer::image == NULL)
		printf("Error loading image.");
	FullRenderer::imageRect = rect;
	FullRenderer::imgX = x;
	FullRenderer::imgY = y;
}

// update function for movement mostly
void FullRenderer::update(double speed = 1) {
	SDL_Event e;
	if (SDL_PollEvent(&e)) {
		if (e.type == SDL_QUIT) FullRenderer::exit = true;
	}

	// check our keyboard for either movement keys or escape key
	// this method removes the "jittering" of testing for keypressed
	const Uint8* keystate = SDL_GetKeyboardState(NULL);
	if (keystate[SDL_SCANCODE_LEFT])
		FullRenderer::imgX -= speed * .1;
	if (keystate[SDL_SCANCODE_RIGHT])
		FullRenderer::imgX += speed * .1;
	if (keystate[SDL_SCANCODE_UP])
		FullRenderer::imgY -= speed * .1;
	if (keystate[SDL_SCANCODE_DOWN])
		FullRenderer::imgY += speed * .1;
	if (keystate[SDL_SCANCODE_ESCAPE])
		FullRenderer::exit = true;

	// test if image has gone out of bounds
	if (imgX + imageRect.w > SDL_GetWindowSurface(FullRenderer::getWindow())->w) {
		imgX = 0;
	}
	else if (imgX <= 0) {
		imgX = (SDL_GetWindowSurface(FullRenderer::getWindow())->w) - imageRect.w;
	}
	else if (imgY <= 0) {
		imgY = (SDL_GetWindowSurface(FullRenderer::getWindow())->h) - imageRect.h;
	}
	else if (imgY + imageRect.h > SDL_GetWindowSurface(FullRenderer::getWindow())->h) {
		imgY = 0;
	}

	FullRenderer::imageRect.x = imgX;
	FullRenderer::imageRect.y = imgY;
}

// displays our renderer and window
void FullRenderer::showWindow() {
	/*
		Set window background color, using colors from the struct in FullRenderer
		then, clear our renderer
		then, render everything in the backbuffer SDL uses (which we draw to before renderPresent).
	*/
	SDL_RenderClear(FullRenderer::getRenderer());
	// renderer color
	SDL_SetRenderDrawColor(FullRenderer::getRenderer(), FullRenderer::colors.r, FullRenderer::colors.g, FullRenderer::colors.b, FullRenderer::colors.a);
	// main loop
	while (!FullRenderer::exit) {
		update();
		// clear the screen
		SDL_RenderClear(FullRenderer::getRenderer());
		// copy the texture to the rendering context
		SDL_RenderCopy(FullRenderer::getRenderer(), FullRenderer::image, NULL, &imageRect);
		// flip the backbuffer
		// this means that everything that we prepared behind the screens is actually shown
		SDL_RenderPresent(FullRenderer::getRenderer());
	}
	IMG_Quit();
	SDL_Quit();
	return;
}