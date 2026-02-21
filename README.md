# AI-Powered Email Assistant

## Executive Summary

**AI-Powered Email Assistant** is a full-stack intelligent email management system that leverages generative AI to automatically generate professional email replies. This project demonstrates expertise in building production-ready applications that integrate modern AI capabilities with seamless user experiences across multiple platforms.

The system comprises three core components:
- **Backend API**: Spring Boot 3.5.7 REST service powered by Google Gemini 2.5 Flash LLM
- **Web Frontend**: Modern React 19 application with Material-UI for desktop interfaces
- **Browser Extension**: Chrome extension for Gmail integration enabling in-context AI assistance

---

## Project Overview

### Problem Statement

Email communication is a critical yet time-consuming aspect of professional work. Users often spend significant time crafting responses, especially when adhering to specific communication tones and styles. This project addresses the productivity challenge by providing intelligent, context-aware email reply generation directly within Gmail.

### Solution Architecture

The application follows a microservices-inspired architecture with clear separation of concerns:

```
Gmail Interface (User)
        ↓
Chrome Extension (Content Script)
        ↓
Spring Boot REST API (http://localhost:8080)
        ↓
Google Gemini 2.5 Flash LLM API
        ↓
Generated Professional Email Reply
```

---

## Technology Stack

### Backend Services

| Component | Technology | Version |
|-----------|-----------|---------|
| Framework | Spring Boot | 3.5.7 |
| Language | Java | 21 |
| Build Tool | Maven | Latest (with wrapper) |
| HTTP Client | Spring WebFlux | 3.5.7 |
| Dependency Injection | Spring DI | Native |
| Serialization | Jackson | Bundled with Spring |
| Code Generation | Project Lombok | Latest |
| Testing Framework | Spring Boot Test | 3.5.7 |

### Frontend Stack

| Component | Technology | Version |
|-----------|-----------|---------|
| Framework | React | 19.2.0 |
| UI Library | Material-UI (MUI) | 7.3.5 |
| Styling | Emotion | 11.14.x |
| HTTP Client | Axios | 1.13.2 |
| Build Tool | Vite | 7.2.4 |
| Linting | ESLint | 9.39.1 |
| Module System | ES Modules | Native |

### Browser Extension

| Component | Technology | Details |
|-----------|-----------|---------|
| Manifest Version | 3 | Latest Chrome Extension API |
| Target Browser | Chrome | Gmail integration |
| Permissions | Content Script | activeTab, storage |
| Host Access | Gmail Platform | *://mail.google.com/* |
| API Integration | Fetch API | Native browser API |

### External AI Service

| Service | Provider | Model |
|---------|----------|-------|
| Generative AI | Google | Gemini 2.5 Flash |
| API Version | REST | v1beta |
| Authentication | API Key | Environment-based |

---

## Project Structure

```
AI-powered-Email-Assistant-Project/
├── Email-Assistant/                          # Spring Boot Backend
│   ├── pom.xml                              # Maven configuration
│   ├── mvnw / mvnw.cmd                      # Maven wrapper (cross-platform)
│   └── src/
│       ├── main/
│       │   ├── java/com/arpitco/Email/Assistant/
│       │   │   ├── EmailAssistantApplication.java      # Spring Boot entry point
│       │   │   ├── EmailGeneratorController.java       # REST endpoint controller
│       │   │   ├── EmailGeneratorService.java          # AI service logic
│       │   │   └── EmailRequest.java                   # Request DTO
│       │   └── resources/
│       │       └── application.properties               # Configuration
│       └── test/
│           └── EmailAssistantApplicationTests.java     # Unit tests
│
├── Email-Assistant-Frontend/                 # React Web Application
│   ├── package.json                         # NPM dependencies
│   ├── vite.config.js                       # Vite build configuration
│   ├── eslint.config.js                     # Linting rules
│   ├── index.html                           # Entry HTML
│   └── src/
│       ├── main.jsx                         # React entry point
│       ├── App.jsx                          # Main application component
│       ├── App.css                          # Component styles
│       ├── index.css                        # Global styles
│       └── assets/                          # Static resources
│
└── email-writer-ext/                        # Chrome Extension
    ├── manifest.json                        # Extension configuration
    ├── content.js                           # Gmail DOM interaction
    └── content.css                          # Extension styling
```

---

## Core Features

### 1. **Intelligent Email Reply Generation**
- Utilizes Google Gemini 2.5 Flash for state-of-the-art natural language understanding and generation
- Processes original email content and generates contextually relevant professional responses
- Supports configurable tone parameters for personalized communication styles

### 2. **Multi-Tone Email Responses**
- **Professional**: Suitable for business communications and formal inquiries
- **Casual**: For friendly, informal correspondence
- **Friendly**: Warm tone while maintaining professionalism
- Dynamic tone injection into prompt engineering for consistent style adherence

### 3. **Seamless Gmail Integration**
- Chrome Extension injects AI generation capability directly into Gmail compose interface
- One-click reply generation without context switching
- Automatic insertion of generated text into compose box
- Non-intrusive UI that matches Gmail's native design language

### 4. **Dual Interface Access**
- **Web Interface** (React): Full-featured desktop application for composition and refinement
- **Extension Interface** (Chrome): Quick-action button in Gmail for rapid email generation

### 5. **Real-time User Feedback**
- Loading state indicators during AI processing
- Copy-to-clipboard functionality for easy content transfer
- Error handling and user-friendly error messages
- Disabled state management for better UX

---

## Installation & Setup

### Prerequisites

- **Java 21+** (for backend development)
- **Node.js 18+** (for frontend development)
- **npm 9+** (package manager)
- **Maven 3.6+** (or use provided Maven wrapper)
- **Chrome/Chromium browser** (for extension)
- **Google Cloud Account** with Gemini API access and valid API key

### Backend Setup

1. **Navigate to backend directory:**
   ```bash
   cd Email-Assistant
   ```

2. **Configure environment variables:**
   Create a `.env` file in the project root:
   ```env
   GEMINI_API_URL=https://generativelanguage.googleapis.com
   GEMINI_API_KEY=your_google_gemini_api_key_here
   ```

3. **Build the project:**
   ```bash
   ./mvnw clean package
   ```

4. **Run the application:**
   - **VS Code Debug Mode** (Recommended): Uses `launch.json` configuration to automatically load `.env` file
   - **IDE**: Run `EmailAssistantApplication.main()` method
   - **Note**: Terminal `mvn spring-boot:run` does not load `.env` properly

   The backend will start on `http://localhost:8080`

### Frontend Setup

1. **Navigate to frontend directory:**
   ```bash
   cd Email-Assistant-Frontend
   ```

2. **Install dependencies:**
   ```bash
   npm install
   ```

3. **Start development server:**
   ```bash
   npm run dev
   ```

   The frontend will be available at `http://localhost:5173`

4. **Build for production:**
   ```bash
   npm run build
   ```

### Chrome Extension Setup

1. **Navigate to extension directory:**
   ```bash
   cd email-writer-ext
   ```

2. **Load extension in Chrome:**
   - Open Chrome and navigate to `chrome://extensions/`
   - Enable **Developer mode** (toggle in top-right corner)
   - Click **Load unpacked**
   - Select the `email-writer-ext` folder
   - Extension will appear in Chrome toolbar

3. **Verify Installation:**
   - Open Gmail (mail.google.com)
   - Open any email to view reply
   - "AI Reply" button should appear in the compose toolbar
   - Backend service must be running at `http://localhost:8080`

---

## API Specification

### Email Generation Endpoint

**POST** `/api/email/generate`

#### Request

```javascript
{
  "emailContent": "string",    // Required: Original email content to reply to
  "tone": "string"              // Optional: professional | casual | friendly
}
```

#### Response

```
HTTP/1.1 200 OK
Content-Type: text/plain

Generated email reply text as plain string
```

#### Example Request

```bash
curl -X POST http://localhost:8080/api/email/generate \
  -H "Content-Type: application/json" \
  -d '{
    "emailContent": "Hi, I wanted to follow up on the project status...",
    "tone": "professional"
  }'
```

#### CORS Configuration

The API is configured with CORS to accept requests from:
- `http://localhost:5173/` (Local React frontend)
- `https://mail.google.com` (Gmail origin)

---

## Implementation Details

### Backend Architecture

#### **EmailGeneratorController** (`@RestController`)
- **Role**: HTTP request handler and routing
- **Endpoint**: `POST /api/email/generate`
- **Responsibilities**:
  - Validates incoming requests
  - Delegates to service layer
  - Handles response serialization
  - CORS management

#### **EmailGeneratorService** (`@Service`)
- **Role**: Business logic orchestration
- **Responsibilities**:
  - Builds intelligent prompts from user input
  - Manages WebClient for async HTTP communication with Gemini API
  - Handles API response parsing and JSON extraction
  - Implements error handling for API failures
  - Tone-aware prompt engineering for style consistency

#### **EmailRequest** (`@Data`)
- **Role**: Data transfer object
- **Fields**:
  - `emailContent`: Original email to generate reply for
  - `tone`: Optional communication style parameter
- **Uses**: Lombok annotations for automatic getter/setter generation

#### **Configuration**
- **Properties**: Environment-based configuration via `application.properties`
- **Dependencies**: Injected via Spring's constructor injection pattern
- **WebClient**: Configured with Gemini API base URL for HTTP operations

### Prompt Engineering Strategy

The application implements sophisticated prompt engineering:

```
"Generate a professional email reply without subject for the following email: 
Use a [tone] tone. 
Original email: 
[user_provided_email_content]"
```

This approach ensures:
- Contextually relevant responses
- Consistent tone adherence
- Clear instruction structure for LLM
- Subject-line omission for flexibility

### Frontend Architecture

#### **App.jsx** (Main Component)
- **State Management**: React hooks (`useState`)
- **States**:
  - `emailContent`: Original email input
  - `tone`: Selected communication style
  - `generatedReply`: AI-generated response
  - `loading`: Loading state during API calls
- **Features**:
  - Form validation (email content required, tone optional)
  - Async request handling with try-catch
  - Loading state UI feedback
  - Error logging and graceful degradation

#### **UI Components** (Material-UI)
- **TextField**: Multi-line text inputs for email composition
- **Select**: Dropdown for tone selection
- **Button**: Actions with loading state indicators
- **CircularProgress**: Visual loading feedback
- **Container**: Responsive layout wrapper

### Chrome Extension Architecture

#### **DOM Interaction** (`content.js`)
- **Email Content Extraction**:
  - Multi-selector fallback strategy for email content
  - Handles various Gmail DOM structures
  - Graceful handling of quote text

- **Toolbar Detection**:
  - Identifies Gmail compose toolbar using multiple selectors
  - Adapts to Gmail UI changes
  - Mutation observer for dynamic content

- **Button Injection**:
  - Creates styled button matching Gmail's native design
  - Applies Gmail's CSS classes for seamless integration
  - Implements accessibility attributes (role, tooltip)

- **Response Insertion**:
  - Detects compose textbox
  - Inserts generated reply using browser's `execCommand`
  - Handles focus management for better UX

#### **Mutation Observer**
- Continuously monitors Gmail DOM for new compose elements
- Re-injects button when Gmail opens new compose window
- Ensures extension remains functional throughout session

#### **Styling** (`content.css`)
- Custom styling for injected button
- Gmail design language compliance
- Hover and active state handling

---

## Usage Examples

### Using the Web Interface

1. **Access the Application**
   - Navigate to `http://localhost:5173`

2. **Generate Reply**
   - Paste original email in "Original Email Content" field
   - Select tone (optional)
   - Click "Generate Reply"
   - Wait for AI to process
   - Review generated response in output field

3. **Copy Response**
   - Click "Copy to Clipboard" to copy the generated reply
   - Paste into your email client

### Using the Chrome Extension

1. **Open Gmail**
   - Navigate to mail.google.com
   - Open an email you want to reply to

2. **Generate Reply**
   - Click "AI Reply" button in compose toolbar
   - Wait for generation (button shows "Generating...")
   - Reply text automatically inserted into compose box

3. **Edit and Send**
   - Review and refine if needed
   - Send email as usual

---

## Configuration & Environment Variables

### Required Environment Variables

```env
# Google Gemini API Configuration
GEMINI_API_URL=https://generativelanguage.googleapis.com
GEMINI_API_KEY=<your_api_key_here>
```

### Application Properties

**File**: `src/main/resources/application.properties`

```properties
# Spring Application Name
spring.application.name=Email-Assistant

# Gemini API Configuration (Loaded from environment)
gemini.api.url=${GEMINI_API_URL}
gemini.api.key=${GEMINI_API_KEY}
```

### Frontend Configuration

**File**: `vite.config.js`
- Configured for development with React Fast Refresh
- Development server runs on port 5173 by default

**File**: `eslint.config.js`
- Enforces code quality standards
- React-specific linting rules

---

## Performance Optimization

### Backend Optimizations

1. **Spring WebFlux**: Non-blocking HTTP calls to Gemini API
2. **Lombok**: Reduced boilerplate code size
3. **Response Streaming**: Direct string response (no JSON wrapping)
4. **Error Handling**: Graceful exception handling without request blocking

### Frontend Optimizations

1. **Vite**: Fast module building and HMR
2. **Code Splitting**: MUI components tree-shaked automatically
3. **State Management**: Minimal re-renders with targeted state updates
4. **Async Operations**: Non-blocking API calls with proper loading states

### Extension Optimizations

1. **Selective DOM Querying**: Multiple selector fallbacks avoid repeated searches
2. **Mutation Observer**: Efficient monitoring of DOM changes
3. **Content Script Isolation**: Runs only on Gmail to minimize overhead
4. **Event Delegation**: Single button click handler for efficiency

---

## Error Handling & Resilience

### API Error Handling

- **Network Failures**: Try-catch blocks in frontend with user notification
- **API Rate Limiting**: Handled by error messages with retry capability
- **Malformed Responses**: JSON parsing with fallback string conversion
- **Missing Content**: Validation ensures email content before submission

### Extension Error Handling

- **DOM Selector Failures**: Multiple fallback selectors for robustness
- **Toolbar Not Found**: Graceful failure with console logging
- **API Connection Issues**: User-friendly error messages
- **Compose Box Detection**: Multiple selector strategies

### User-Facing Feedback

- Loading state indicators prevent repeated submissions
- Disabled button states during processing
- Error console logging for debugging
- Copy-to-clipboard feedback

---

## Security Considerations

### API Security

- **API Key Management**: Stored in environment variables, never in code
- **CORS Configuration**: Restricted to known origins (localhost, Gmail)
- **HTTPS Ready**: Extension host permissions specify HTTPS
- **Input Validation**: Request validation on controller level

### Extension Security

- **Content Security Policy**: Defined in manifest.json
- **Limited Permissions**: Only necessary permissions requested
- **Domain Restriction**: Only runs on mail.google.com
- **No External Scripts**: All code included locally

### Data Privacy

- No data persistence beyond current session
- Generated replies not stored on server
- User content transmitted only to Google Gemini API
- No tracking or analytics implementation

---

## Testing

### Backend Testing

**File**: `src/test/java/com/arpitco/Email/Assistant/EmailAssistantApplicationTests.java`

- Uses Spring Boot Test framework
- JUnit for test execution
- Integration testing capabilities

**Run Tests:**
```bash
./mvnw test
```

### Frontend Testing

**Run Linting:**
```bash
npm run lint
```

**Note**: Current test suite focuses on linting. Unit tests can be added using Vitest or Jest.

---

## Deployment Considerations

### Backend Deployment

1. **Build Docker Image**:
   ```dockerfile
   FROM openjdk:21
   COPY target/Email-Assistant-0.0.1-SNAPSHOT.jar app.jar
   ENTRYPOINT ["java","-jar","/app.jar"]
   ```

2. **Environment Setup**: Configure environment variables on deployment platform
3. **Port Mapping**: Ensure port 8080 is exposed
4. **Dependency**: Requires internet access to Gemini API

### Frontend Deployment

1. **Build**: `npm run build`
2. **Output**: Static files in `dist/` directory
3. **Hosting**: Any static file hosting (Vercel, Netlify, AWS S3)
4. **Base URL**: Update API endpoint in `App.jsx` for production

### Extension Deployment

1. **Package**: Zip the `email-writer-ext` directory
2. **Chrome Web Store**: Submit for review and distribution
3. **Update Manifest**: Version increment for updates
4. **API Endpoint**: Configure production backend URL

---

## Future Enhancement Roadmap

### Phase 2 Features

1. **Multiple LLM Support**
   - Integration with OpenAI GPT-4, Claude
   - Provider selection in UI
   - Cost optimization

2. **Advanced Customization**
   - User-defined tone templates
   - Signature management
   - Email template library
   - Email language selection

3. **Analytics & Insights**
   - Usage statistics
   - Response generation time tracking
   - User feedback on generated emails
   - Improvement metrics

4. **Cloud Infrastructure**
   - Database integration for user profiles
   - Email history persistence
   - Synchronization across devices
   - User authentication

5. **Enhanced Extension Features**
   - One-click editing without compose box reopening
   - Email thread context for better replies
   - Bulk email processing
   - Attachment handling

6. **Performance Improvements**
   - Caching mechanism for similar email patterns
   - Response time optimization
   - Connection pooling
   - Background processing queue

---

## Troubleshooting

### Backend Issues

| Issue | Solution |
|-------|----------|
| `.env file not found` | Use VS Code Debug mode or set env vars in system/IDE |
| `API Key error` | Verify `GEMINI_API_KEY` environment variable is set |
| `Port 8080 already in use` | Kill existing process or change port in application.properties |
| `CORS errors` | Ensure frontend runs on localhost:5173 and extension on Gmail |

### Frontend Issues

| Issue | Solution |
|-------|----------|
| `Cannot connect to backend` | Verify backend is running on http://localhost:8080 |
| `Port 5173 already in use` | Change port in vite.config.js or kill existing process |
| `MUI components not loading` | Run `npm install` and verify node_modules |

### Extension Issues

| Issue | Solution |
|-------|----------|
| `Extension not showing` | Reload extension in chrome://extensions |
| `AI Reply button not visible` | Open developer tools and check console for errors |
| `API request failing` | Ensure backend is running at http://localhost:8080 |
| `Gmail UI changes break extension` | Update selectors in content.js to match new Gmail structure |

---

## Contributing & Development Workflow

### Code Standards

- **Java**: Follow Spring Boot conventions, use @Autowired for standard dependencies
- **JavaScript/JSX**: ESLint configured for code quality
- **React**: Functional components with hooks pattern
- **Styling**: CSS modules or inline styles with emotion/styled-components

### Development Process

1. **Create Feature Branch**: `git checkout -b feature/your-feature`
2. **Make Changes**: Follow code standards
3. **Test Locally**: Run all three components
4. **Commit**: `git commit -m "feat: description"`
5. **Push**: `git push origin feature/your-feature`

---

## Project Metrics & Technical Achievements

### Code Statistics

- **Backend**: ~250 lines of Java code (Spring Boot)
- **Frontend**: ~100 lines of React (with MUI)
- **Extension**: ~120 lines of JavaScript (content script)
- **Configuration**: XML (Maven), JSON (vite, eslint, manifest), Properties

### Technology Integration Points

- REST API with async non-blocking operations
- Real-time LLM API integration
- Browser extension development with content scripts
- React modern patterns with hooks
- Responsive Material-UI design system

### Key Design Patterns Used

1. **Dependency Injection**: Spring DI for loose coupling
2. **Service Layer Pattern**: Separation of concerns (Controller → Service)
3. **DTO Pattern**: EmailRequest for data transfer
4. **Observer Pattern**: Mutation observer in extension
5. **Factory Pattern**: WebClient builder for HTTP client creation

---

## License

This project is provided as-is for educational and professional purposes.

---

## Contact & Support

For questions or issues regarding this project, refer to the source code comments and configuration files for implementation details.

---

## Summary

**AI-Powered Email Assistant** demonstrates full-stack development capabilities with:

✅ **Modern Backend Architecture**: Spring Boot 3.5.7 with reactive programming  
✅ **Contemporary Frontend**: React 19 with Material-UI for professional UI/UX  
✅ **Browser Integration**: Chrome extension for seamless Gmail integration  
✅ **AI Integration**: Google Gemini 2.5 Flash for intelligent content generation  
✅ **Production-Ready Code**: CORS handling, error management, configuration management  
✅ **Scalable Design**: Microservices-ready architecture with clear separation of concerns  
✅ **Professional Implementation**: Industry-standard patterns and best practices  

This project exemplifies the ability to build complete, functional applications that solve real-world productivity challenges while maintaining code quality and architectural best practices.

---

**Last Updated**: February 2026

