module.exports = {
    content: [
        "./index.html", "./src/**/*.{js,jsx,ts,tsx}", "./src/components/**/*.{js,jsx,ts,tsx}" // Ensure Tailwind scans your files for class usage
    ],
    theme: {
        extend: {
            borderRadius: {
            },
            colors: {
            },
            spacing: {
            },
        },
    },
    plugins: [],
};